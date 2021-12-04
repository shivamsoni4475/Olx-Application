package com.olx.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Advertise;
import com.olx.entity.AdvertiseEntity;
import com.olx.repository.AdvertiseRepository;

@Service
public class AdvertiseDataConverter {

	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	public Advertise convertAdvertiseEntityIntoAdvertiseDTO(AdvertiseEntity advertiseEntity){
		Advertise advertiseDto = this.modelMapper.map(advertiseEntity, Advertise.class);
		return advertiseDto;
	}
}
