package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.CityDAO;
import com.diankangwo.domain.City;

@Repository
public class CityDAOImpl extends BaseDaoImpl<City> implements CityDAO{

	@Override
	public List<City> findByProId(Integer proId) {
		List<City> cityList = new ArrayList<City>();
		cityList =  findByQuery("from City city where city.ProvinceID = ?", proId);
		if (cityList == null || cityList.size() ==0) {
			return null;
		}else{
			return cityList;
		}
	}

}
