package com.digiratina.vehiclepark.payload.request;

import com.digiratina.vehiclepark.constant.VehicleType;

import lombok.Data;

@Data
public class VehicleParkInRequest {

	private Integer id;

	private String number;

	private VehicleType type;

	private Integer slotId;

}
