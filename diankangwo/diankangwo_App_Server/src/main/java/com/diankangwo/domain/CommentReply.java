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
 * 评论回复
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "CommentReply")
@Table(name = "td_CommentReply")
public class CommentReply implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	/**
	 * 内容
	 */
	@Column(name = "content")
	private String content;
	
	/**
	 * 添加时间
	 */
	@Column(name = "add_date")
	private Timestamp add_date;
	
	/**
	 * 用户id
	 */
	@OneToOne
	@JoinColumn(name = "userId")
	private UserInfo userInfo;
	
	/**
	 * 评论ID
	 */
	@Column(name = "commentsId")
	private Integer commentsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Timestamp add_date) {
		this.add_date = add_date;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(Integer commentsId) {
		this.commentsId = commentsId;
	}
}
