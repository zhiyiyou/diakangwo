package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户头像
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "UserProfile")
@Table(name = "td_UserProfile")
public class UserProfile implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 创建时间
	 */
	@Column(name = "createDate")
	private Timestamp createDate;
	/**
	 * 创建人
	 */
	@Column(name = "createUser")
	private String createUser;
	
	@Column(name = "originName")
	private String originName;

	@Column(name = "realName")
	private String realName;
	/**
	 * 文件大小
	 */
	@Column(name = "fileSize")
	private Long fileSize;
	/**
	 * 存放路径
	 */
	@Column(name = "storeFolder")
	private String storeFolder;
	/**
	 * 文件类型
	 */
	@Column(name = "fileType")
	private String fileType;
	/**
	 * 更新时间
	 */
	@Column(name = "updateDate")
	private Timestamp updateDate;
	/**
	 * 更新人 
	 */
	@Column(name = "updateUser")
	private String updateUser;

	public UserProfile() {
	}

	public UserProfile(int id) {
		this.id = id;
	}

	public UserProfile(int id, Timestamp createDate, String createUser, String originName, String realName, Long fileSize,
			String storeFolder, String fileType, Timestamp updateDate, String updateUser) {
		this.id = id;
		this.createDate = createDate;
		this.createUser = createUser;
		this.originName = originName;
		this.realName = realName;
		this.fileSize = fileSize;
		this.storeFolder = storeFolder;
		this.fileType = fileType;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getOriginName() {
		return this.originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getStoreFolder() {
		return this.storeFolder;
	}

	public void setStoreFolder(String storeFolder) {
		this.storeFolder = storeFolder;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
