package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.Invitation;

public interface InvitationDAO extends BaseDAO<Invitation>{
	public List<Invitation> findByUid(Integer id);
	public List<Invitation> findByFUid(String fuid);
}
