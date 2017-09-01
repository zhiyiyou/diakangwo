package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.Port;

public interface PortDAO extends BaseDAO<Port> {
	public List<Port> findByType(String type);
	
	public List<Port> findByUser(Integer userId);
	
	public Port findByPortId(String portId);
	
	public Port findByPortCondition(String f_name, String f_id_card, String f_tel);
}
