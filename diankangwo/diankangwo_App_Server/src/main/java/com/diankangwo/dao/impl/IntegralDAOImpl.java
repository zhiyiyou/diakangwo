package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.IntegralDAO;
import com.diankangwo.domain.Integral;

@Repository
public class IntegralDAOImpl extends BaseDaoImpl<Integral> implements IntegralDAO {

	@Override
	public List<Integral> getUserByUid(String uid) {
		List<Integral> iglList = new ArrayList<Integral>();
		iglList =  findByQuery("from Integral igl where igl.uid = ?", uid);
		if (iglList == null || iglList.size() ==0) {
			return null;
		}else{
			return iglList;
		}
	}

}
