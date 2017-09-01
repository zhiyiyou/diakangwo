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
 * 用户领取的优惠券
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "CouponsUser")
@Table(name = "td_CouponsUser")
public class CouponsUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 名称
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 用户UID
	 */
	@Column(name = "uid")
	private String uid;
	/**
	 * 金额
	 */
	@Column(name = "denomination")
	private Long denomination;
	/**
	 * 有效期开始时间
	 */
	@Column(name = "start_date")
	private Timestamp start_date;
	/**
	 * 有效期结束时间
	 */
	@Column(name = "end_date")
	private Timestamp end_date;
	/**
	 * 详情
	 */
	@Column(name = "detail")
	private String detail;
	/**
	 * 使用限制
	 */
	@Column(name = "use_condition")
	private String use_condition;
	/**
	 * 被使用的时间(可为空)
	 */
	@Column(name = "used_date")
	private Timestamp used_date;
	
	/**
	 * 被使用的时间(可为空)
	 */
	@Column(name = "type")
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDenomination() {
		return denomination;
	}
	public void setDenomination(Long denomination) {
		this.denomination = denomination;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getUse_condition() {
		return use_condition;
	}
	public void setUse_condition(String use_condition) {
		this.use_condition = use_condition;
	}
	public Timestamp getUsed_date() {
		return used_date;
	}
	public void setUsed_date(Timestamp used_date) {
		this.used_date = used_date;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
