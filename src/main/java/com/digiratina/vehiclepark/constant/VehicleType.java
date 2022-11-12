package com.digiratina.vehiclepark.constant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum VehicleType {


	CAR(0, "Car"),
	BIKE(1, "Bike"),
	THREE_WHEEL(2, "3 Wheel");

	private Integer id;
	private String name;

	private VehicleType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<VehicleType> getVehicleTypes(){

		return Stream.of(
				VehicleType.CAR,
				VehicleType.BIKE,
				VehicleType.THREE_WHEEL
				).collect(Collectors.toList());
	}

}
