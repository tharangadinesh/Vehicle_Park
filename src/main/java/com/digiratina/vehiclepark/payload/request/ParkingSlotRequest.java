package com.digiratina.vehiclepark.payload.request;

import lombok.Data;

@Data
public class ParkingSlotRequest {

	private String name;
	private Boolean isFree = true;

}
