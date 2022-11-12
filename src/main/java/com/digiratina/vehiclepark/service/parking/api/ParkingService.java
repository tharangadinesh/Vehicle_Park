package com.digiratina.vehiclepark.service.parking.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.digiratina.vehiclepark.dto.park.ParkingEntryDTO;
import com.digiratina.vehiclepark.payload.request.VehicleParkInRequest;
import com.digiratina.vehiclepark.payload.request.VehicleParkOutRequest;
import com.digiratina.vehiclepark.payload.response.ParkingResponse;

public interface ParkingService {

	ResponseEntity<ParkingResponse> parkInSlot(VehicleParkInRequest vehicleParkInRequest);

	ResponseEntity<ParkingResponse> exitFromSlot(VehicleParkOutRequest vehicleParkOutRequest);

	ResponseEntity<List<ParkingEntryDTO>> getAllParkingEntries();
}
