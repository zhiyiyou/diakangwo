package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.DistrictDAO;
import com.diankangwo.domain.District;

@Repository
public class DistrictDAOImpl extends BaseDaoImpl<District> implements DistrictDAO {

	@Override
	public List<District> findByCityId(Integer cityId) {
		List<District> disList = new ArrayList<District>();
		disList =  findByQuery("from District dis where dis.CityID = ?", cityId);
		if (disList == null || disList.size() ==0) {
			return null;
		}else{
			return disList;
		}
	}

}
