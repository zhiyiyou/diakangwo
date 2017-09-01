package com.diankangwo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 图片
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Picture")
@Table(name = "td_Picture")
public class Picture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 文件名称
	 */
	@Column(name = "fileName")
	private String fileName;
	/**
	 * 文件类型
	 */
	@Column(name = "fileType")
	private String fileType;
	/**
	 * 文件大小
	 */
	@Column(name = "fileSize")
	private int fileSize;
	/**
	 * 存储路径
	 */
	@Column(name = "fileUrl")
	private String fileUrl;

	public Picture() {
	}

	public Picture(int id, String fileName, String fileType, int fileSize, String fileUrl) {
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.fileUrl = fileUrl;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
