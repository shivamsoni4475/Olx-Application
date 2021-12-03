package com.olx.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.MasterDataService;

@RestController
@RequestMapping("olx")
public class MasterDataController  {

	@Autowired
	private MasterDataService masterDataService;
	
	
	// 5 API - Return all advertisement categories
	@GetMapping(value="/advertise/category", produces = MediaType.APPLICATION_JSON_VALUE)
	public List  <Category> getAllCategories(){
		return this.masterDataService.getAllCategories();
	}
		

	// 6 API - Return all possible advertise status
	@GetMapping(value="/advertise/status",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Status> getAllStatus(){
		return this.masterDataService.getAllStatus();
	}
	
	
}
