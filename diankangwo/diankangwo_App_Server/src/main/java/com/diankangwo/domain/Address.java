package com.diankangwo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 地址信息
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Address")
@Table(name = "td_Address")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 用户信息
	 */
	@Column(name = "uid")
	private String uid; // 用户信息
	/**
	 * 省
	 */
	@OneToOne
	@JoinColumn(name = "provinceId")
	private Province provinceId; // 省
	/**
	 * 城市
	 */
	@OneToOne
	@JoinColumn(name = "cityId")
	private City cityId; // 城市
	/**
	 * 区域
	 */
	@OneToOne
	@JoinColumn(name = "districtId")
	private District districtId; // 区域
	/**
	 * 详细地址
	 */
	@Column(name = "detailedAddress")
	private String detailedAddress; // 详细地址
	/**
	 * 邮编
	 */
	@Column(name = "postcode")
	private String postcode; // 邮编
	/**
	 * 电话号码
	 */
	@Column(name = "phone")
	private String phone; // 电话号码

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetailedAddress() {
		return this.detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Province getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Province provinceId) {
		this.provinceId = provinceId;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public District getDistrictId() {
		return districtId;
	}

	public void setDistrictId(District districtId) {
		this.districtId = districtId;
	}
}
