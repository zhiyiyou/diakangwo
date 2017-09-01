package com.diankangwo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diankangwo.dao.IntegralInfoDAO;
import com.diankangwo.domain.IntegralInfo;
import com.diankangwo.service.IntegralInfoServices;
import com.diankangwo.util.PageSupport;

@Service
public class IntegralInfoServicesImpl implements IntegralInfoServices {

	@Autowired
	private IntegralInfoDAO integralInfoDAO;
	
	@Override
	public void saveOrUpdate(IntegralInfo t) {
		integralInfoDAO.saveOrUpdate(t);
	}

	@Override
	public void deleteById(Integer id) {
		integralInfoDAO.deleteById(id);	
	}

	@Override
	public PageSupport<IntegralInfo> findPagination(int pageNo, int pageSize) {
		return null;
	}


}
