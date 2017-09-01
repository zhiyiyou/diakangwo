package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.PortPayLogDAO;
import com.diankangwo.domain.PortPayLog;

@Repository
public class PortPayLogDAOImpl extends BaseDaoImpl<PortPayLog> implements PortPayLogDAO {

	@Override
	public List<PortPayLog> findByDays(String port_id) {
		List<PortPayLog> portList = new ArrayList<PortPayLog>();
		portList =  findByQuery("from PortPayLog portPayLog where portPayLog.portId = ? and  DateDiff(dd,date,getdate())<=30", port_id);
		if (portList == null || portList.size() ==0) {
			return null;
		}else{
			return portList;
		}
	}

	@Override
	public List<PortPayLog> findByMonths(String port_id) {
		List<PortPayLog> portList = new ArrayList<PortPayLog>();
		portList =  findByQuery("from PortPayLog portPayLog where portPayLog.portId = ? and  DateDiff(mm,date,getdate())=0", port_id);
		if (portList == null || portList.size() ==0) {
			return null;
		}else{
			return portList;
		}
	}

	@Override
	public List<PortPayLog> findByYears(String port_id) {
		List<PortPayLog> portList = new ArrayList<PortPayLog>();
		portList =  findByQuery("from PortPayLog portPayLog where portPayLog.portId = ? and  DateDiff(yy,date,getdate())=0", port_id);
		if (portList == null || portList.size() ==0) {
			return null;
		}else{
			return portList;
		}
	}

	@Override
	public List<PortPayLog> findByQuarters(String port_id) {
		return null;
	}

}
