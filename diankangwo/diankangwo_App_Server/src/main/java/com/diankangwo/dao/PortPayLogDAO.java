package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.PortPayLog;

public interface PortPayLogDAO extends BaseDAO<PortPayLog> {
	public List<PortPayLog> findByDays(String port_id);
	
	public List<PortPayLog> findByMonths(String port_id);
	
	public List<PortPayLog> findByYears(String port_id);
	
	public List<PortPayLog> findByQuarters(String port_id);
}
