/*package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertise;
import com.olx.repository.AdvertiseRepository;
import com.olx.service.AdvertiseService;


@RestController
@RequestMapping("olx")
public class AdvertiseController {

	@Autowired
    private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private AdvertiseService advertiseService;
	
	@GetMapping(value="/advertise", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAllAdvertise(){
		return this.advertiseService.getAllAdvertise();
	}
}
*/
package com.olx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertise;
import com.olx.repository.AdvertiseRepository;
import com.olx.service.AdvertiseService;




@RestController
@RequestMapping("/olx")
public class AdvertiseController {
	

	@Autowired
    private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private AdvertiseService advertiseService;
	
	
	
	@PostMapping(value="/advertise" , produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Advertise createNewAdvertise(@RequestHeader("auth-token") String authToken,@RequestBody Advertise advertise)
	{
		return this.advertiseService.createNewAdvertise(advertise);
	}

	@GetMapping(value="/user/advertise", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAllAdvertise(@RequestHeader("auth-token") String authToken){
	//public List<Advertise> getAllAdvertise(){
		System.out.println("Auth-Token : " + authToken);
		return this.advertiseService.getAllAdvertise();
	}
	
	@GetMapping(value="/advertise/postId",produces=MediaType.APPLICATION_JSON_VALUE)
	public Advertise getAdvertiseById(@RequestParam("postId") int postId, @RequestHeader("auth-token") String authToken){
	   
					return this.advertiseService.getAdvertiseById(postId, authToken);
		}
	
	@DeleteMapping(value="/user/advertise/{postId}")
	public boolean  deleteAdvertiseByID(@PathVariable("id") int postId) {
		return this.advertiseService.deleteAdvertiseByID(postId);
	}
	
	@PutMapping(value="/advertise/postId", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public Advertise updateItem(@RequestParam("postId") int postId, @RequestHeader("auth-token") String authToken, @RequestBody Advertise advertise) {
		
		return this.advertiseService.updateItem(postId, authToken, advertise);
	}
	/*
	@GetMapping(value="/advertise/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAdvertiseByName(@PathVariable("name") String name) {
		return stockService.findByName(name);
	}

	@GetMapping(value="/stock/marketname/{marketname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByMarketName(@PathVariable("marketname") String marketname) {
		return stockService.findByMarketName(marketname);
	}

	@GetMapping(value="/stock/marketname/{marketname}/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByNameAndMarketName(@PathVariable("marketname") String marketname, @PathVariable("name") String name) {
		return stockService.findByNameAndMarketName(name, marketname);
	}


	@GetMapping(value="/stock/name/like/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStocksByNameLike(@PathVariable("name") String name) {
		return advertiseService.findByNameLike(name);
	}
	*/

	@GetMapping(value="/advertise/name/sort/{sortType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAdvertiseOrderByName(@PathVariable("sortType") String sortType) {
		return advertiseService.findByOrderByName(sortType);
	}

	@GetMapping(value="/advertise/page/{startIndex}/{records}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAdvertiseByPage(@PathVariable("startIndex") int startIndex, @PathVariable("records") int records) {
		return advertiseService.findByPage(startIndex, records);
	}
	
	@GetMapping(value="/advertise/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAdvertiseByName(@PathVariable("name") String name) {
		return advertiseService.findByName(name);
	}

	
}
	


