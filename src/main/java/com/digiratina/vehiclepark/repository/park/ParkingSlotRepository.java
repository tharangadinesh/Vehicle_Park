package com.digiratina.vehiclepark.repository.park;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digiratina.vehiclepark.model.park.ParkingSlot;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {

	@Query("FROM ParkingSlot WHERE isFree = true")
	List<ParkingSlot> findAllFreeSlot();

}
