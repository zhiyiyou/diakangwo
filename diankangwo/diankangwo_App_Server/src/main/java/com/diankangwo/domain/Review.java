package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 评论
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Review")
@Table(name = "td_Review")
public class Review implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 商品ID
	 */
	@ManyToOne
	@JoinColumn(name="commodityID") 
	private Commodity commodity;
	/**
	 * 用户名
	 */
	@Column(name = "userName")
	private String userName;
	/**
	 * 用户IP
	 */
	@Column(name = "userIp")
	private String userIp;
	/**
	 * 评论内容
	 */
	@Column(name = "reviewText")
	private String reviewText;
	/**
	 * 是否审核
	 */
	@Column(name = "reviewCheck")
	private Boolean reviewCheck;
	/**
	 * 评论时间
	 */
	@Column(name = "reviewTime")
	private Timestamp reviewTime;

	public Review() {
	}

	public Review(int id, Commodity commodity) {
		this.id = id;
		this.commodity = commodity;
	}

	public Review(int id, Commodity commodity, String userName, String userIp, String reviewText, Boolean reviewCheck,
			Timestamp reviewTime) {
		this.id = id;
		this.commodity = commodity;
		this.userName = userName;
		this.userIp = userIp;
		this.reviewText = reviewText;
		this.reviewCheck = reviewCheck;
		this.reviewTime = reviewTime;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getReviewText() {
		return this.reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public Boolean getReviewCheck() {
		return this.reviewCheck;
	}

	public void setReviewCheck(Boolean reviewCheck) {
		this.reviewCheck = reviewCheck;
	}

	public Date getReviewTime() {
		return this.reviewTime;
	}

	public void setReviewTime(Timestamp reviewTime) {
		this.reviewTime = reviewTime;
	}

}
