package com.diankangwo.dto;

import com.diankangwo.domain.UserInfo;

public class PortDto {
	private int id;
	/**
	 * 用户信息
	 */
	private UserInfo userinfo;
	/**
	 * 端口ID
	 */
	private int portId;
	/**
	 * 当前价格
	 */
	private long present_value;
	/**
	 * 是否是销售状态
	 */
	private Integer saleing;
	/**
	 * 转让价格
	 */
	private long price;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 证书图片地址
	 */
	private String certificate_pic_url;
	/**
	 * 端口来源
	 */
	private String source;
	/**
	 * 天
	 */
	private String days;
	/**
	 * 月
	 */
	private String months;
	/**
	 * 年
	 */
	private String years;
	/**
	 * 季度
	 */
	private String quarters;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserInfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public int getPortId() {
		return this.portId;
	}

	public void setPortId(int portId) {
		this.portId = portId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCertificate_pic_url() {
		return certificate_pic_url;
	}

	public void setCertificate_pic_url(String certificate_pic_url) {
		this.certificate_pic_url = certificate_pic_url;
	}

	public long getPresent_value() {
		return present_value;
	}

	public void setPresent_value(long present_value) {
		this.present_value = present_value;
	}

	public Integer getSaleing() {
		return saleing;
	}

	public void setSaleing(Integer saleing) {
		this.saleing = saleing;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getQuarters() {
		return quarters;
	}

	public void setQuarters(String quarters) {
		this.quarters = quarters;
	}

}
