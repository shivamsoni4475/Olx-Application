package com.olx.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.olx.dto.Advertise;

public interface AdvertiseService {

	public List<Advertise> getAllAdvertise();

	public Advertise createNewAdvertise(@RequestBody Advertise advertise);
	public Advertise getAdvertiseById(@RequestParam("postId") int postId, @RequestHeader("auth-token") String authToken);
	public boolean  deleteAdvertiseByID(@PathVariable("id") int postId);
	public Advertise updateItem(@RequestParam("postId") int postId, @RequestHeader("auth-token") String authToken, @RequestBody Advertise advertise);

	List<Advertise> findByName(String name);
	
	List<Advertise> findByOrderByName(String sortType);
	List<Advertise> findByPage(int startIndex, int records);
	
}
