package com.digiratina.vehiclepark.service.slot.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.digiratina.vehiclepark.dto.park.ParkingSlotDTO;
import com.digiratina.vehiclepark.payload.request.ParkingSlotRequest;
import com.digiratina.vehiclepark.payload.response.ParkingResponse;

public interface ParkingSlotService {

	ResponseEntity<ParkingResponse> createParkingSlot(ParkingSlotRequest parkingSlotRequest);

	ResponseEntity<List<ParkingSlotDTO>> getAllFreeParkingSlots();

	ResponseEntity<List<ParkingSlotDTO>> getAllParkingSlots();

}
