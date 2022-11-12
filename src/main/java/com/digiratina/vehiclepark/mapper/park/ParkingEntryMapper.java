package com.digiratina.vehiclepark.mapper.park;

import com.digiratina.vehiclepark.dto.park.ParkingEntryDTO;
import com.digiratina.vehiclepark.mapper.GenericMapper;
import com.digiratina.vehiclepark.model.park.ParkingEntry;

public class ParkingEntryMapper extends GenericMapper<ParkingEntry, ParkingEntryDTO> {

	private static ParkingEntryMapper instance = null;

	private ParkingEntryMapper() {}

	public static ParkingEntryMapper getInstance() {

		if (instance == null) {
			instance = new ParkingEntryMapper();
		}

		return instance;
	}

	@Override
	public ParkingEntryDTO domainToDto(ParkingEntry domain) throws Exception {

		ParkingEntryDTO dto = new ParkingEntryDTO();

		dto.setId(domain.getId());
		dto.setInTime(domain.getInTime());
		dto.setOutTime(domain.getOutTime());
		dto.setFare(domain.getFare());

		if (domain.getVehicle() != null) {
			dto.setVehicleNumber(domain.getVehicle().getNumber());
		}

		if (domain.getSlot() != null) {
			dto.setSlotName(domain.getSlot().getName());
		}

		return dto;
	}

	@Override
	public void dtoToDomain(ParkingEntryDTO dto, ParkingEntry domain) throws Exception {

		domain.setId(dto.getId());
		domain.setInTime(dto.getInTime());
		domain.setOutTime(dto.getOutTime());
		domain.setFare(dto.getFare());

	}

}
