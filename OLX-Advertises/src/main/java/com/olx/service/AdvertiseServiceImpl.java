package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.olx.dto.Advertise;
import com.olx.entity.AdvertiseEntity;
import com.olx.repository.AdvertiseRepository;


@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	static List<Advertise> advertises = new ArrayList<Advertise>();
	static int LastPostId = 0;
	
/*
	@Override
    public List<Advertise> getAllAdvertise(){
		List<AdvertiseEntity> advertiseEntities = advertiseRepository.findAll();
		List<Advertise> advertiseDtoList = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity: advertiseEntities) {
			Advertise advertiseDto = new Advertise();
			advertiseDto.setId(advertiseEntity.getId());
			advertiseDto.setTitle(advertiseEntity.getTitle());
			advertiseDto.setPrice(advertiseEntity.getPrice());
			advertiseDto.setCategory(advertiseEntity.getCategory());
			advertiseDto.setDescription(advertiseEntity.getDescription());
			advertiseDto.setUsername(advertiseEntity.getUsername());
			advertiseDto.setStatus(advertiseEntity.getStatus());
			advertiseDto.setCreatedDate(advertiseEntity.getCreatedDate());
			advertiseDto.setModifiedDate(advertiseEntity.getModifiedDate());
			advertiseDtoList.add(advertiseDto);
		}
		return advertiseDtoList;
	}
*/
	@Override
	public List<Advertise> getAllAdvertise(){
		
		List<AdvertiseEntity> advertiseEntities=advertiseRepository.findAll();
		return getAdvertiseDtoList(advertiseEntities);
	}
	
	private List<Advertise> getAdvertiseDtoList(List<AdvertiseEntity> advertiseEntityList) {
		List<Advertise> advertiseDtoList = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity: advertiseEntityList) {
			Advertise advertiseDto = this.modelMapper.map(advertiseEntity, Advertise.class);
			advertiseDtoList.add(advertiseDto);
		}
		return advertiseDtoList;
	}
	
	
	
	@Override
	public Advertise createNewAdvertise(@RequestBody Advertise advertise)
	{
		advertise.setId(++LastPostId);
		advertises.add(advertise);
		return advertise;
	}

	
	
	@Override
	public Advertise getAdvertiseById(@RequestParam("postId") int postId, @RequestHeader("auth-token") String authToken){
	     System.err.println("Auth-Token" + authToken);
		for(Advertise advertise: advertises ) {
				if(advertise.getId()==postId) {
					return advertise;
			}
		}
		return null;
	}
	
	@Override
	public boolean  deleteAdvertiseByID(@PathVariable("id") int postId) {
		for(Advertise advertise: advertises) {
			if(advertise.getId()==postId)
			{
				advertises.remove(advertise);
				return true;
				
			}
	}
		return false;
	}
	
	@Override
	public Advertise updateItem(@RequestParam("postId") int postId, @RequestHeader("auth-token") String authToken, @RequestBody Advertise advertise) {
		for(Advertise tempAdvertise: advertises) {
			if(tempAdvertise.getId()==postId) {
				tempAdvertise.setTitle(tempAdvertise.getTitle());
				tempAdvertise.setPrice((tempAdvertise.getPrice()));
				tempAdvertise.setCategory(tempAdvertise.getCategory());
				tempAdvertise.setStatus(tempAdvertise.getStatus());
				tempAdvertise.setDescription(tempAdvertise.getDescription());
				return tempAdvertise;
		}
	}
		return advertise;
		
	}
	
	
	@Override
	public List<Advertise> findByName(String name) {
		List<AdvertiseEntity> stockEntityList = advertiseRepository.findByName(name);
		return getAdvertiseDtoList(stockEntityList);
	}
	
	
	@Override
	public List<Advertise> findByOrderByName(String sortType) {
		List<AdvertiseEntity> advertiseEntityList = null;
		if("ASC".equalsIgnoreCase(sortType)) {
			advertiseEntityList = advertiseRepository.findByOrderByNameAsc();
		
			List<Sort.Order> sortOrders = new ArrayList<Sort.Order>();
			Sort.Order order_1 = new Sort.Order(Sort.Direction.ASC, "name");
			
			sortOrders.add(order_1);
	
			advertiseEntityList = advertiseRepository.findAll(Sort.by(sortOrders));
			advertiseEntityList = advertiseRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.DESC, "price")));
		
		}
		if("DESC".equalsIgnoreCase(sortType)) {
			advertiseEntityList = advertiseRepository.findByOrderByNameDesc();
		}
		return getAdvertiseDtoList(advertiseEntityList);
	}
	
	
	  @Override
	  public List<Advertise> findByPage(int startIndex, int records) {
			Pageable pageWithFewRecords = PageRequest.of(startIndex, records);
			Page<AdvertiseEntity> advertiseEntityPage = advertiseRepository.findAll(pageWithFewRecords);
			List<AdvertiseEntity> advertiseEntityList = advertiseEntityPage.getContent();
			return getAdvertiseDtoList(advertiseEntityList);
		}
	
}
