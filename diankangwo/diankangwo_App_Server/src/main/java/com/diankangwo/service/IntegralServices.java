package com.diankangwo.service;

import java.util.List;

import com.diankangwo.domain.Integral;

public interface IntegralServices extends BaseService<Integral> {
	public List<Integral> getUserByUid(String uid);
}
