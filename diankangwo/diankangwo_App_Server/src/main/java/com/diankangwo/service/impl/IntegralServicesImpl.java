package com.diankangwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diankangwo.dao.IntegralDAO;
import com.diankangwo.domain.Integral;
import com.diankangwo.service.IntegralServices;
import com.diankangwo.util.PageSupport;

@Service
public class IntegralServicesImpl implements IntegralServices {

	@Autowired
	private IntegralDAO IntegralDAO;
	
	@Override
	public void saveOrUpdate(Integral t) {
		IntegralDAO.saveOrUpdate(t);
	}

	@Override
	public void deleteById(Integer id) {
		IntegralDAO.deleteById(id);
	}

	@Override
	public PageSupport<Integral> findPagination(int pageNo, int pageSize) {
		return null;
	}

	@Override
	public List<Integral> getUserByUid(String uid) {
		return IntegralDAO.getUserByUid(uid);
	}

}
