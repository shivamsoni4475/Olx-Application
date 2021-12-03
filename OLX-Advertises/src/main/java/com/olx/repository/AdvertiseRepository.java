package com.olx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.olx.entity.AdvertiseEntity;

public interface AdvertiseRepository extends JpaRepository<AdvertiseEntity, Integer>{
	
	List<AdvertiseEntity> findByName(String name);
	List<AdvertiseEntity> findByOrderByNameAsc();
	List<AdvertiseEntity> findByOrderByNameDesc();
	
	@Query(value="SELECT * FROM Users ORDER BY current_value", nativeQuery = true)
	List<AdvertiseEntity> sortByPriceDesc();
	
	List<AdvertiseEntity> findAllByOrderByDate();
}
