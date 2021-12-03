package com.olx.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.entity.CategoryEntity;

@Service
public class MasterDataConverter {

	@Autowired
	ModelMapper modelMapper;
	
	public Category convertCategoryEntityIntoCategoryDTO(CategoryEntity categoryEntity) {
		
		/*
		Category categoryDto = new Category();
		categoryDto.setId(categoryEntity.getId());
		categoryDto.setCategory(categoryEntity.getCategory());
		*/
		// map() function takes two arguments - source type, destination type
		// Source is our category entity
		// Destination is category Dto
		// Destination type is Category.class because we don't have object for category dto 
		Category categoryDto = this.modelMapper.map(categoryEntity, Category.class);
		return categoryDto;
	}
}
