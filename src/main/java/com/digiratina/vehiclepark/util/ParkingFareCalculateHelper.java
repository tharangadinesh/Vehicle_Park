package com.digiratina.vehiclepark.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ParkingFareCalculateHelper {

	private static final Double minimumFare = 50.0;

	public static Double calculate(Date inTime, Date outTime) {

		LocalDateTime enterTime = LocalDateTime.ofInstant(inTime.toInstant(), ZoneId.systemDefault());;
		LocalDateTime exitTime = LocalDateTime.ofInstant(outTime.toInstant(), ZoneId.systemDefault());;

		Long diffInHours = java.time.Duration.between(enterTime, exitTime).toHours();

		if(diffInHours > 1) {
			return minimumFare + ((diffInHours -1 ) * 20);
		} else {
			return minimumFare;
		}
	}

}
