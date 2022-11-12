package com.digiratina.vehiclepark.dto.vehicle;

import com.digiratina.vehiclepark.constant.VehicleType;
import com.digiratina.vehiclepark.dto.BaseDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class VehicleDTO extends BaseDTO {

	private Integer id;

	private final String number;

	private final VehicleType vehicleType;

}
