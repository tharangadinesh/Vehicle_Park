package com.digiratina.vehiclepark.dto.park;

import java.util.Date;

import com.digiratina.vehiclepark.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingEntryDTO extends BaseDTO {

	private Integer id;

	private String slotName;
	private String vehicleNumber;

	//Assume minimum fare is 50/=
	private Double fare = 50.0;

	private Date inTime;
	private Date outTime;

}
