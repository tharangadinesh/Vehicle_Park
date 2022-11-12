package com.digiratina.vehiclepark.service.vehicle.api;

import com.digiratina.vehiclepark.dto.vehicle.VehicleDTO;
import com.digiratina.vehiclepark.model.vehicle.Vehicle;

public interface VehicleService {

	Vehicle save(VehicleDTO dto) throws Exception;

}
