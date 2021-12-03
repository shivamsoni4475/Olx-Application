package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryEntity;
import com.olx.entity.StatusEntity;
import com.olx.repository.CategoryRepository;
import com.olx.repository.StatusRepository;



@Service 
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<Category> getAllCategories() {
		// It has CRUD operations findAll()
		// And it returns list of category entity 
		List<CategoryEntity> categoriesEntities = categoryRepository.findAll();
		// This is the entity class because repository knows about entity only it do not know anything about DTO
	    // So you will get all entities
		// But you say i want returns of data but my data in the controller is written in category dto object
		// So someone has to convert category entity list into category dto list
		// So we create an array list of category
		List<Category> categoriesDtoList = new ArrayList<Category>();
		
		TypeMap<CategoryEntity, Category> typeMap = this.modelMapper.typeMap(CategoryEntity.class, Category.class);
	    typeMap.addMappings((mapper) -> {
	    	mapper.map(source->source.getCategory(), Category::setCategoryName);
	    	// mapper.map(source->source.getId(), Category::setCategoryId);
	    });
		
		// Using for loop to iterate in this category entity list which I am getting from database system
		for(CategoryEntity categoryEntity: categoriesEntities) {
	        // Using setters 
			// Converting category entity list into category dto list
			// Category categoryDto = new Category();
			// categoryDto.setId(categoryEntity.getId());
			// categoryDto.setCategory(categoryEntity.getCategory());
			// Here we are just calling the functionality we have created in utils package
			// Category categoryDto = MasterDataConverter.convertCategoryEntityIntoCategoryDTO(categoryEntity);
				
			Category categoryDto = this.modelMapper.map(categoryEntity, Category.class);
			categoriesDtoList.add(categoryDto);
		}
		// Returning categoriesDtoList
		return categoriesDtoList;
	}




	@Override
	public List<Status> getAllStatus() {
		List<StatusEntity> statusEntities = statusRepository.findAll();
		List<Status> statusDtoList = new ArrayList<Status>();
		for(StatusEntity statusEntity: statusEntities) {
	        // Using setters 
			// Converting category entity list into category dto list
			Status statusDto = new Status();
			statusDto.setId(statusEntity.getId());
			statusDto.setStatus(statusEntity.getStatus());
			statusDtoList.add(statusDto);
		}
		// Returning categoriesDtoList
		return statusDtoList;
	}
	

/*	
	private List<Category> getCategoryDtoList(List<CategoryEntity> categoryEntityList) {
		List<Category> categoryDtoList = new ArrayList<Category>();
		for(CategoryEntity categoryEntity: categoryEntityList) {
			Category categoryDto = this.modelMapper.map(categoryEntity, Category.class);
			categoryDtoList.add(categoryDto);
		}
		return categoryDtoList;
	}
*/

  


}
