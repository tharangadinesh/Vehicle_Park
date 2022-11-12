package com.digiratina.vehiclepark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiratina.vehiclepark.dto.park.ParkingEntryDTO;
import com.digiratina.vehiclepark.dto.park.ParkingSlotDTO;
import com.digiratina.vehiclepark.payload.request.ParkingSlotRequest;
import com.digiratina.vehiclepark.payload.response.ParkingResponse;
import com.digiratina.vehiclepark.service.parking.api.ParkingService;
import com.digiratina.vehiclepark.service.slot.api.ParkingSlotService;

@RestController
@RequestMapping(ParkingController.REST_API)
public class ParkingController {

	public final static String REST_API = "parking";

	@Autowired
	private ParkingSlotService parkSlotService;

	@Autowired
	private ParkingService parkingService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/slot")
	public ResponseEntity<ParkingResponse> createParkingSlot(@RequestBody ParkingSlotRequest parkingSlotRequest) {

		return parkSlotService.createParkingSlot(parkingSlotRequest);
	}

	@GetMapping("/slots")
	public ResponseEntity<List<ParkingSlotDTO>> getAllParkingSlots() {

		return parkSlotService.getAllParkingSlots();

	}

	@GetMapping("/slots/free")
	public ResponseEntity<List<ParkingSlotDTO>> getAllFreeParkingSlots() {

		return parkSlotService.getAllFreeParkingSlots();

	}

	@GetMapping("/entries")
	public ResponseEntity<List<ParkingEntryDTO>> getAllParkingEntries(){

		return parkingService.getAllParkingEntries();
	}
}
