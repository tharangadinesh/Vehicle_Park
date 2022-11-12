package com.digiratina.vehiclepark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiratina.vehiclepark.payload.request.VehicleParkInRequest;
import com.digiratina.vehiclepark.payload.request.VehicleParkOutRequest;
import com.digiratina.vehiclepark.payload.response.ParkingResponse;
import com.digiratina.vehiclepark.service.parking.api.ParkingService;

@RestController
@RequestMapping(VehicleController.REST_API)
public class VehicleController {

	public final static String REST_API = "vehicle";

	@Autowired
	private ParkingService parkingService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/park-in-slot")
	public ResponseEntity<ParkingResponse> createVehicleEntryFlow(@RequestBody VehicleParkInRequest vehicleParkRequest) {

		return parkingService.parkInSlot(vehicleParkRequest);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/park-out-slot")
	public ResponseEntity<ParkingResponse> createVehicleOutFlow(@RequestBody VehicleParkOutRequest vehicleParkOutRequest) {

		return parkingService.exitFromSlot(vehicleParkOutRequest);

	}

}
