package com.digiratina.vehiclepark.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.digiratina.vehiclepark.constant.VehicleType;
import com.digiratina.vehiclepark.model.BaseModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_vehicle")
public class Vehicle extends BaseModel {

	private static final long serialVersionUID = -8883961515749380196L;

	@Id
	@GeneratedValue(generator = "vehicle_s")
	@SequenceGenerator(name = "vehicle_s", sequenceName = "vehicle_s", initialValue = 1)
	private Integer id;

	@Column(name = "number")
	private String number;

	@Column(name = "type")
	private VehicleType type;

	public Vehicle(String number, VehicleType type) {
		super();
		this.number = number;
		this.type = type;
	}

}
