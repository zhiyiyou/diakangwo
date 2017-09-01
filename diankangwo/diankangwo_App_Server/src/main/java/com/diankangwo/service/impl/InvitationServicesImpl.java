package com.diankangwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diankangwo.dao.InvitationDAO;
import com.diankangwo.domain.Invitation;
import com.diankangwo.service.InvitationServices;
import com.diankangwo.util.PageSupport;

@Service
public class InvitationServicesImpl implements InvitationServices {

	@Autowired
	private InvitationDAO invitationDao;
	
	@Override
	public void saveOrUpdate(Invitation t) {
		invitationDao.saveOrUpdate(t);
	}

	@Override
	public void deleteById(Integer id) {
		invitationDao.deleteById(id);		
	}

	@Override
	public PageSupport<Invitation> findPagination(int pageNo, int pageSize) {
		return invitationDao.findPagination("", pageNo, pageSize);
	}

	@Override
	public List<Invitation> findByUid(Integer uid) {
		return invitationDao.findByUid(uid);
	}

}
