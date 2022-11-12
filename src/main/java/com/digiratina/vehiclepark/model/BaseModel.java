package com.digiratina.vehiclepark.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = -5356423279919704668L;

	@Column(name = "created_date", nullable = false)
	protected Date createdDate;

	@Version
	@Column(name = "version")
	protected Integer version;

	@PrePersist
	public void prePersist() {
		createdDate = new Date();
	}

}
