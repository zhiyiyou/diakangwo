package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.ClassificationDAO;
import com.diankangwo.domain.Classification;

@Repository
public class ClassificationDAOImpl extends BaseDaoImpl<Classification> implements ClassificationDAO {

	@Override
	public List<Classification> findByTypeId(Integer id) {
		List<Classification> cftList = new ArrayList<Classification>();
		cftList =  findByQuery("from Classification cft where cft.typeId = ?", id);
		if (cftList == null || cftList.size() ==0) {
			return null;
		}else{
			return cftList;
		}
	}

}
