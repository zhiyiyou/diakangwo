package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.City;

public interface CityDAO extends BaseDAO<City> {
	
	public List<City> findByProId(Integer proId);

}
