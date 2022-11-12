package com.digiratina.vehiclepark.model.park;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.digiratina.vehiclepark.model.BaseModel;
import com.digiratina.vehiclepark.model.vehicle.Vehicle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_park_entry")
public class ParkingEntry extends BaseModel {

	private static final long serialVersionUID = -8883961515749380196L;

	@Id
	@GeneratedValue(generator = "park_entry_s")
	@SequenceGenerator(name = "park_entry_s", sequenceName = "park_entry_s", initialValue = 1)
	private Integer id;

	@Column(name = "intime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date inTime;

	@Column(name = "outtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date outTime;

	@Column(name = "fare")
	private Double fare;

	@JoinColumn(name = "vehicle_id", nullable = false)
	@OneToOne( targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	private Vehicle vehicle;

	@JoinColumn(name = "slot_id", nullable = false)
	@OneToOne( targetEntity = ParkingSlot.class, fetch = FetchType.LAZY)
	private ParkingSlot slot;

	public ParkingEntry(Date inTime, Vehicle vehicle, ParkingSlot slot) {
		super();
		this.inTime = inTime;
		this.vehicle = vehicle;
		this.slot = slot;
	}

}
