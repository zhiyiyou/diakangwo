package com.diankangwo.dao;

import java.util.List;
import com.diankangwo.domain.District;

public interface DistrictDAO extends BaseDAO<District> {

	public List<District> findByCityId(Integer cityId);
}
