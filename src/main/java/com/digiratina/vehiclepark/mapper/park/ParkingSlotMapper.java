package com.digiratina.vehiclepark.mapper.park;

import com.digiratina.vehiclepark.dto.park.ParkingSlotDTO;
import com.digiratina.vehiclepark.mapper.GenericMapper;
import com.digiratina.vehiclepark.model.park.ParkingSlot;

public class ParkingSlotMapper extends GenericMapper<ParkingSlot, ParkingSlotDTO> {

	private static ParkingSlotMapper instance = null;

	private ParkingSlotMapper() {}

	public static ParkingSlotMapper getInstance() {

		if (instance == null) {
			instance = new ParkingSlotMapper();
		}

		return instance;
	}

	@Override
	public ParkingSlotDTO domainToDto(ParkingSlot domain) throws Exception {

		ParkingSlotDTO dto = new ParkingSlotDTO(domain.getName(), domain.getIsFree());
		dto.setId(domain.getId());

		return dto;
	}

	@Override
	public void dtoToDomain(ParkingSlotDTO dto, ParkingSlot domain) throws Exception {

		domain.setId(dto.getId());

	}

}
