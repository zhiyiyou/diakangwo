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
 * 用户收藏表
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Collection")
@Table(name = "td_Collection")
public class Collection implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	/**
	 * 用户UID
	 */
	@Column(name = "uid")
	private String uid;
	
	/**
	 * 商品ID
	 */
	@Column(name = "goods_id")
	private String goods_id;
	
	/**
	 * 分类ID
	 */
	@Column(name = "class_id")
	private String class_id;
	
	/**
	 * 商品名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 商品价格
	 */
	@Column(name = "price")
	private String price;
	
	/**
	 * 商品图片地址
	 */
	@Column(name = "pic_url")
	private String pic_url;
	
	/**
	 * 添加时间
	 */
	@Column(name = "add_date")
	private Timestamp add_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
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

	public Timestamp getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Timestamp add_date) {
		this.add_date = add_date;
	}
	
}
