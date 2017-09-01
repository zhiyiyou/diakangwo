package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 浏览记录表
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "BrowseLog")
@Table(name = "td_BrowseLog")
public class BrowseLog implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	/**
	 * 标题
	 */
	@Column(name = "title")
	private String title;
	
	/**
	 * 用户uid
	 */
	@Column(name = "uid")
	private String uid;
	

	/**
	 * 商品Id
	 */
	@OneToOne
	@JoinColumn(name = "commodity_id")
	private Commodity commodity_id;

	/**
	 * 商品名称
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 金额
	 */
	@Column(name = "price")
	private String price;

	/**
	 * 图片地址
	 */
	@Column(name = "pic_url")
	private String pic_url;

	/**
	 * 时间
	 */
	@Column(name = "date")
	private Timestamp date;

	/**
	 * 分类id
	 */
	@Column(name = "class_id")
	private Integer class_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Commodity getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(Commodity commodity_id) {
		this.commodity_id = commodity_id;
	}

}
