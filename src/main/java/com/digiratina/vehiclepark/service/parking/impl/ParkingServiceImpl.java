package com.digiratina.vehiclepark.service.parking.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.digiratina.vehiclepark.dto.park.ParkingEntryDTO;
import com.digiratina.vehiclepark.dto.vehicle.VehicleDTO;
import com.digiratina.vehiclepark.mapper.park.ParkingEntryMapper;
import com.digiratina.vehiclepark.model.park.ParkingEntry;
import com.digiratina.vehiclepark.model.park.ParkingSlot;
import com.digiratina.vehiclepark.model.vehicle.Vehicle;
import com.digiratina.vehiclepark.payload.request.VehicleParkInRequest;
import com.digiratina.vehiclepark.payload.request.VehicleParkOutRequest;
import com.digiratina.vehiclepark.payload.response.ParkingResponse;
import com.digiratina.vehiclepark.repository.park.ParkingEntryRepository;
import com.digiratina.vehiclepark.repository.park.ParkingSlotRepository;
import com.digiratina.vehiclepark.service.parking.api.ParkingService;
import com.digiratina.vehiclepark.service.vehicle.api.VehicleService;
import com.digiratina.vehiclepark.util.ParkingFareCalculateHelper;

@Service
public class ParkingServiceImpl implements ParkingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingServiceImpl.class);

	@Autowired
	private ParkingSlotRepository parkSlotRepository;

	@Autowired
	private ParkingEntryRepository parkingEntryRepository;

	@Autowired
	private VehicleService vehicleService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ResponseEntity<ParkingResponse> exitFromSlot(VehicleParkOutRequest vehicleParkOutRequest) {

		try {

			Optional<ParkingEntry> optional = parkingEntryRepository.findById( vehicleParkOutRequest.getId() );

			if (optional.isPresent()) {

				ParkingEntry parkingEntry = optional.get();

				updateParkingEntry(parkingEntry);
				updateParkingSlot(parkingEntry);

				return new ResponseEntity<ParkingResponse>(new ParkingResponse("Vehicle exit from parking slot"), HttpStatus.OK);

			} else {

				return new ResponseEntity<ParkingResponse>(new ParkingResponse("Invalid slot or vehicle, Cannot find any record!"), HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error occure while saving exit from slot due to, {}", e.getMessage());
		}

		return new ResponseEntity<ParkingResponse>(new ParkingResponse("Error "), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	private void updateParkingEntry(ParkingEntry parkingEntry) {
		parkingEntry.setOutTime(new Date());
		parkingEntry.setFare(ParkingFareCalculateHelper.calculate(parkingEntry.getInTime(), parkingEntry.getOutTime()));

		parkingEntryRepository.save(parkingEntry);
	}

	private void updateParkingSlot(ParkingEntry parkingEntry) {
		ParkingSlot parkingSlot = parkingEntry.getSlot();
		parkingSlot.setIsFree(true);

		parkSlotRepository.save(parkingSlot);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ParkingEntryDTO>> getAllParkingEntries() {

		try {
			Optional<List<ParkingEntry>> optional = Optional.ofNullable( parkingEntryRepository.findAll() );
			List<ParkingEntryDTO> parkingEntryDTOs = ParkingEntryMapper.getInstance().domainToDTOList(optional.get());

			return 	new ResponseEntity<List<ParkingEntryDTO>>(parkingEntryDTOs, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<ParkingEntryDTO>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ResponseEntity<ParkingResponse> parkInSlot(VehicleParkInRequest vehicleParkRequest) {

		try {

			Optional<ParkingSlot> optSlot = parkSlotRepository.findById(vehicleParkRequest.getSlotId());

			if (optSlot.isPresent()) {

				ParkingSlot parkingSlot = optSlot.get();

				Vehicle vehicle = vehicleService.save(new VehicleDTO(vehicleParkRequest.getNumber(), vehicleParkRequest.getType()));

				if (parkingSlot.getIsFree()) {

					ParkingEntry parkingEntry = new ParkingEntry(new Date(), vehicle, parkingSlot);

					parkingEntryRepository.save(parkingEntry);

					parkingSlot.setIsFree(false);

					parkSlotRepository.save(parkingSlot);

					return new ResponseEntity<ParkingResponse>(new ParkingResponse("Vehicle parking entry created"), HttpStatus.CREATED);

				} else {
					LOGGER.info("Parking Slot is not free {}" , parkingSlot.getName());
					return new ResponseEntity<ParkingResponse>(new ParkingResponse("Parking Slot is not free"), HttpStatus.CONFLICT);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error occure while saving parking in to slot due to, {}", e.getMessage());
		}

		return new ResponseEntity<ParkingResponse>(new ParkingResponse("Invalid slot, Could not locate slot for Vehicle"), HttpStatus.NOT_FOUND);
	}

}
