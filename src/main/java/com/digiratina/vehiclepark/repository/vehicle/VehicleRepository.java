package com.digiratina.vehiclepark.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digiratina.vehiclepark.model.vehicle.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	Vehicle findByNumber(String number);

}
