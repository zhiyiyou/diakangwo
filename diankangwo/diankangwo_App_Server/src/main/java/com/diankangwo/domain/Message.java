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
 * 消息中心
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
 @Entity(name = "Message")
 @Table(name = "td_Message")
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 消息类型
	 */
	@Column(name = "type")
	private Integer type;
	/**
	 * 发布时间
	 */
	@Column(name = "time")
	private Timestamp time;
	/**
	 * 内容
	 */
	@Column(name = "content")
	private String content;
	/**
	 * 状态
	 */
	@Column(name = "state")
	private Integer state;

	public Message() {
	}

	public Message(int id) {
		this.id = id;
	}

	public Message(int id, Integer type, Timestamp time, String content, Integer state) {
		this.id = id;
		this.type = type;
		this.time = time;
		this.content = content;
		this.state = state;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
