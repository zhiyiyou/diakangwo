package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * 区域
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "District")
@Table(name = "td_s_district")
public class District implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DistrictID", unique = true, nullable = false)
	private int DistrictID;
	
	/**
	 * 区域名称
	 */
	@JoinColumn(name="DistrictName") 
	private String DistrictName;	
	
	/**
	 * 城市ID
	 */
	@JoinColumn(name="CityID") 
	private Integer CityID;
	
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

	public int getDistrictID() {
		return DistrictID;
	}

	public void setDistrictID(int districtID) {
		DistrictID = districtID;
	}

	public String getDistrictName() {
		return DistrictName;
	}

	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}

	public Integer getCityID() {
		return CityID;
	}

	public void setCityID(Integer cityID) {
		CityID = cityID;
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
