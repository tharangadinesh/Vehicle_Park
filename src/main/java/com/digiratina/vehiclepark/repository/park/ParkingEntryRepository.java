package com.digiratina.vehiclepark.repository.park;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digiratina.vehiclepark.model.park.ParkingEntry;

@Repository
public interface ParkingEntryRepository extends JpaRepository<ParkingEntry, Integer> {

}
