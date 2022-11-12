package com.digiratina.vehiclepark.dto.park;

import com.digiratina.vehiclepark.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ParkingSlotDTO extends BaseDTO {

	private Integer id;

	private final String name;

	private final Boolean isFree;
}
