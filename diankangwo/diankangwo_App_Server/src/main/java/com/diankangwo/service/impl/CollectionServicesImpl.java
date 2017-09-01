package com.diankangwo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diankangwo.dao.CollectionDAO;
import com.diankangwo.domain.Collection;
import com.diankangwo.service.CollectionServices;
import com.diankangwo.util.PageSupport;

@Service
public class CollectionServicesImpl implements CollectionServices {
	
	@Autowired
	private CollectionDAO collectionDao;
	
	@Override
	public void saveOrUpdate(Collection t) {
		collectionDao.saveOrUpdate(t);
	}

	@Override
	public void deleteById(Integer id) {
		collectionDao.deleteById(id);
	}

	@Override
	public PageSupport<Collection> findPagination(int pageNo, int pageSize) {
		return null;
	}

}
