package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.diankangwo.dao.PortDAO;
import com.diankangwo.domain.Port;

@Repository
public class PortDAOImpl extends BaseDaoImpl<Port> implements PortDAO {

	@Override
	public List<Port> findByType(String type) {
		List<Port> portList = new ArrayList<Port>();
		if (type.equals("saleing")) {
			portList = findByQuery("from Port p where p.type = ?", "attorn");
		} else {
			portList = findByQuery("from Port p ");
		}

		if (portList == null || portList.size() == 0) {
			return null;
		} else {
			return portList;
		}
	}

	@Override
	public List<Port> findByUser(Integer userId) {
		List<Port> portList = new ArrayList<Port>();
		portList = findByQuery("from Port p where p.userinfo.id = ?", userId);
		if (portList == null || portList.size() == 0) {
			return null;
		} else {
			return portList;
		}
	}

	@Override
	public Port findByPortId(String portId) {
		List<Port> portList = new ArrayList<Port>();
		portList = findByQuery("from Port p where p.portId = ?", portId);
		if (portList == null || portList.size() == 0) {
			return null;
		} else {
			return portList.get(0);
		}
	}

	@Override
	public Port findByPortCondition(String f_name, String f_id_card, String f_tel) {
		List<Port> portList = new ArrayList<Port>();
		portList = findByQuery("from Port p where p.id_card = ? and p.name = ? and p.tel = ?",f_id_card,f_name,f_tel);
		if (portList == null || portList.size() == 0) {
			return null;
		} else {
			return portList.get(0);
		}
	}

}
