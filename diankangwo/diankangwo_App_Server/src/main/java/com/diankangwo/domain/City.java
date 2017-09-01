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
 * 城市
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "City")
@Table(name = "td_s_city")
public class City implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CityID", unique = true, nullable = false)
	private int CityID;
	
	/**
	 * 城市名称
	 */
	@Column(name="CityName") 
	private String CityName;	
	
	/**
	 * 邮编
	 */
	@Column(name="ZipCode") 
	private String ZipCode;
	
	/**
	 * 省份ID
	 */
	@Column(name="ProvinceID") 
	private String ProvinceID;
	
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

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getProvinceID() {
		return ProvinceID;
	}

	public void setProvinceID(String provinceID) {
		ProvinceID = provinceID;
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
