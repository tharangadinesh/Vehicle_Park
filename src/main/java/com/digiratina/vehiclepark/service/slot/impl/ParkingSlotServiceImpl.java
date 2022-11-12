package com.digiratina.vehiclepark.service.slot.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digiratina.vehiclepark.dto.park.ParkingSlotDTO;
import com.digiratina.vehiclepark.mapper.park.ParkingSlotMapper;
import com.digiratina.vehiclepark.model.park.ParkingSlot;
import com.digiratina.vehiclepark.payload.request.ParkingSlotRequest;
import com.digiratina.vehiclepark.payload.response.ParkingResponse;
import com.digiratina.vehiclepark.repository.park.ParkingSlotRepository;
import com.digiratina.vehiclepark.service.slot.api.ParkingSlotService;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingSlotServiceImpl.class);

	@Autowired
	private ParkingSlotRepository parkSlotRepository;


	@Override
	public ResponseEntity<ParkingResponse> createParkingSlot(ParkingSlotRequest parkingSlotRequest) {

		try {
			ParkingSlot parkSlot = new ParkingSlot( parkingSlotRequest.getName(), parkingSlotRequest.getIsFree());

			parkSlotRepository.save(parkSlot);

			return new ResponseEntity<>(new ParkingResponse("Successfully created parking slot") ,HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error occured while saving parking slot due to, {}", e.getMessage() );
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@Override
	public ResponseEntity<List<ParkingSlotDTO>> getAllParkingSlots() {

		try {

			Optional<List<ParkingSlot>> parkingSlots = Optional.ofNullable(parkSlotRepository.findAll());
			return new ResponseEntity<>(ParkingSlotMapper.getInstance().domainToDTOList(parkingSlots.get()), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error occured while fetching parking slot due to, {}", e.getMessage() );
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}


	@Override
	public ResponseEntity<List<ParkingSlotDTO>> getAllFreeParkingSlots() {

		try {

			Optional<List<ParkingSlot>> parkingSlots = Optional.ofNullable(parkSlotRepository.findAllFreeSlot());
			return new ResponseEntity<>(ParkingSlotMapper.getInstance().domainToDTOList(parkingSlots.get()), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error occured while fetching free parking slot due to, {}", e.getMessage() );
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}
