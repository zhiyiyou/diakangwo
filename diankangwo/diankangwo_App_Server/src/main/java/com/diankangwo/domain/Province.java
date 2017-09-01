package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 省份
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Province")
@Table(name = "td_s_province")
public class Province implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProvinceID", unique = true, nullable = false)
	private int ProvinceID;
	
	/**
	 * 省份名称
	 */
	@Column(name="ProvinceName") 
	private String ProvinceName;	

	/**
	 * 创建时间
	 */
	@Column(name="DateCreated") 
	private Timestamp DateCreated;
	
	/**
	 * 修改时间
	 */
	@Column(name="DateUpdated") 
	private Timestamp DateUpdated;

	public int getProvinceID() {
		return ProvinceID;
	}

	public void setProvinceID(int provinceID) {
		ProvinceID = provinceID;
	}

	public String getProvinceName() {
		return ProvinceName;
	}

	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}

	public Timestamp getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		DateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return DateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		DateUpdated = dateUpdated;
	}
	
	
}
