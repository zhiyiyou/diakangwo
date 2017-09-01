package com.diankangwo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户积分信息类
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "IntegrakInfo")
@Table(name = "td_IntegrakInfo")
public class IntegralInfo implements Serializable {
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
	 * 内容
	 */
	@Column(name = "content")
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
