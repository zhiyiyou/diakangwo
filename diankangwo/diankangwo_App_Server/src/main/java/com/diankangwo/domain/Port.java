package com.diankangwo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 端口
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Port")
@Table(name = "td_Port")
public class Port implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 用户信息
	 */
	@ManyToOne
	@JoinColumn(name="userID") 
	private UserInfo userinfo;
	/**
	 * 端口ID
	 */
	@Column(name = "portId")
	private int portId;
	/**
	 * 当前价格
	 */
	@Column(name = "present_value")
	private long present_value;
	/**
	 * 是否是销售状态
	 */
	@Column(name = "saleing")
	private Integer saleing;
	/**
	 * 转让价格
	 */
	@Column(name = "price")
	private long price;
	/**
	 * 类型
	 */
	@Column(name = "type")
	private String type;
	/**
	 * 证书图片地址
	 */
	@Column(name = "certificate_pic_url")
	private String certificate_pic_url;
	/**
	 * 端口来源
	 */
	@Column(name = "source")
	private String source;
	
	/**
	 * 身份证
	 */
	@Column(name = "id_card")
	private String id_card;
	
	/**
	 * 姓名
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 手机号
	 */
	@Column(name = "tel")
	private String tel;
	
	/**
	 * 预约金额
	 */
	@Column(name = "money")
	private Float money;
	
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

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

}
