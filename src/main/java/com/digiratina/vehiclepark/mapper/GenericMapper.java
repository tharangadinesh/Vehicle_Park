package com.digiratina.vehiclepark.mapper;

import java.util.ArrayList;
import java.util.List;

import com.digiratina.vehiclepark.dto.BaseDTO;
import com.digiratina.vehiclepark.model.BaseModel;

public abstract class GenericMapper<DOMAIN extends BaseModel, DTO extends BaseDTO> {

	public abstract DTO domainToDto(DOMAIN domain) throws Exception;

	public abstract void dtoToDomain(DTO dto, DOMAIN domain) throws Exception;

	public List<DTO> domainToDTOList(final Iterable<? extends DOMAIN> domainList) throws Exception{
		if(domainList == null) {
			return new ArrayList<>();
		}
		final List<DTO> dtoList = new ArrayList<>();

		for(final DOMAIN domain : domainList){
			dtoList.add(domainToDto(domain));
		}
		return dtoList;
	}

}
