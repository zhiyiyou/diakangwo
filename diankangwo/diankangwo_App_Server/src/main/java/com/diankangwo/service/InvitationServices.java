package com.diankangwo.service;

import java.util.List;

import com.diankangwo.domain.Invitation;

public interface InvitationServices extends BaseService<Invitation> {
	public List<Invitation> findByUid(Integer uid);
}
