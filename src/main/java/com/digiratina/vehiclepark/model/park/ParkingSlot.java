package com.digiratina.vehiclepark.model.park;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.digiratina.vehiclepark.model.BaseModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tbl_park_slot")
public class ParkingSlot extends BaseModel{

	private static final long serialVersionUID = 2039689102463275238L;

	@Id
	@GeneratedValue(generator = "park_slot_s")
	@SequenceGenerator(name = "park_slot_s", sequenceName = "park_slot_s", initialValue = 1)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "isfree")
	private Boolean isFree;

	public ParkingSlot(String name, Boolean isFree) {
		super();
		this.name = name;
		this.isFree = isFree;
	}

}
