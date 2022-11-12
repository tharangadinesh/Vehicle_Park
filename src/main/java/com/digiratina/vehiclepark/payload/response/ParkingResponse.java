package com.digiratina.vehiclepark.payload.response;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParkingResponse {

	private final String msg;
	private final Date dateTime = new Date(System.currentTimeMillis());

}
