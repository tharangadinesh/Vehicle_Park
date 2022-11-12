package com.digiratina.vehiclepark.service.vehicle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.digiratina.vehiclepark.dto.vehicle.VehicleDTO;
import com.digiratina.vehiclepark.model.vehicle.Vehicle;
import com.digiratina.vehiclepark.repository.vehicle.VehicleRepository;
import com.digiratina.vehiclepark.service.vehicle.api.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Vehicle save(VehicleDTO dto) throws Exception {

		Vehicle vehicle = new Vehicle(dto.getNumber(), dto.getVehicleType());

		vehicle = vehicleRepository.save(vehicle);

		return vehicle;
	}

}
