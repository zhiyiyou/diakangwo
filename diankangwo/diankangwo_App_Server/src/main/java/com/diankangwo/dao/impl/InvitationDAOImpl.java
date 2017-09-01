package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.InvitationDAO;
import com.diankangwo.domain.Invitation;

@Repository
public class InvitationDAOImpl extends BaseDaoImpl<Invitation> implements InvitationDAO  {

	@Override
	public List<Invitation> findByUid(Integer id) {
		List<Invitation> invitationList = new ArrayList<Invitation>();
		invitationList =  findByQuery("from Invitation i where i.uid = ?", id);
		if (invitationList == null || invitationList.size() ==0) {
			return null;
		}else{
			return invitationList;
		}
	}

	@Override
	public List<Invitation> findByFUid(String fuid) {
		List<Invitation> invitationList = new ArrayList<Invitation>();
		invitationList =  findByQuery("from Invitation i where i.fuid = ?", fuid);
		if (invitationList == null || invitationList.size() ==0) {
			return null;
		}else{
			return invitationList;
		}
	}

}
