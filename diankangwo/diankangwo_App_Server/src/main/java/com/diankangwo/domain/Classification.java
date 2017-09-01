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
 * 二级分类
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Classification")
@Table(name = "td_Classification")
public class Classification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	/**
	 * 一级分类ID
	 */
	@Column(name = "typeId")
	private Integer typeId;
	/**
	 * 分类名称
	 */
	@Column(name = "className")
	private String className;
	
	/**
	 * 分类描述
	 */
	@Column(name = "classText")
	private String classText;
	/**
	 * 显示级别
	 */
	@Column(name = "classOrder")
	private Integer classOrder;
	/**
	 * 二级分类显示
	 */
	@Column(name = "classCheck")
	private Integer classCheck;
	/**
	 * 录入时间
	 */
	@Column(name = "classTime")
	private Timestamp classTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassText() {
		return classText;
	}
	public void setClassText(String classText) {
		this.classText = classText;
	}
	public Integer getClassOrder() {
		return classOrder;
	}
	public void setClassOrder(Integer classOrder) {
		this.classOrder = classOrder;
	}
	public Integer getClassCheck() {
		return classCheck;
	}
	public void setClassCheck(Integer classCheck) {
		this.classCheck = classCheck;
	}
	public Timestamp getClassTime() {
		return classTime;
	}
	public void setClassTime(Timestamp classTime) {
		this.classTime = classTime;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
}
