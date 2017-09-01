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
 * 评论信息
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Comments")
@Table(name = "td_Comments")
public class Comments implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	/**
	 * 商品ID
	 */
	@OneToOne
	@JoinColumn(name = "commodityId")
	private Commodity commodity;
	
	/**
	 * 用户id
	 */
	@OneToOne
	@JoinColumn(name = "userId")
	private UserInfo userInfo;
	
	/**
	 * 类型
	 */
	@Column(name = "type")
	private String type;
	
	/**
	 * 内容
	 */
	@Column(name = "content")
	private String content;
	
	/**
	 * 图片
	 */
	@Column(name = "pic")
	private String pic;
	
	/**
	 * 添加时间
	 */
	@Column(name = "add_date")
	private Timestamp add_date;
	
	/**
	 * 点赞数
	 */
	@Column(name = "like")
	private Integer like;
	
	/**
	 * 回复数
	 */
	@Column(name = "reply_number")
	private Integer reply_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Timestamp getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Timestamp add_date) {
		this.add_date = add_date;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Integer getReply_number() {
		return reply_number;
	}

	public void setReply_number(Integer reply_number) {
		this.reply_number = reply_number;
	}
}
