package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 用户权限信息实体类
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Role")
@Table(name = "td_role")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	/**
	 * UUID
	 */
	private String uuid;
	/**
	 * 权限代码
	 */
	@Column(name = "Role_code")
	private String role_code;
	/**
	 * 权限描述
	 */
	@Column(name = "Role_desc")
	private String role_desc;
	/**
	 * 权限名称
	 */
	@Column(name = "Role_name")
	private String role_name;
	/**
	 * 状态
	 */
	@Column(name = "enabled")
	private boolean Enabled = true;
	/**
	 * 创建日期
	 */
	@Column(name = "Create_data")
	private Timestamp create_date;
	/**
	 * 创建人
	 */
	@Column(name = "Create_user")
	private String create_user;
	/**
	 * 更新日期
	 */
	@Column(name = "Update_date")
	private Timestamp update_date;
	/**
	 * 更新者
	 */
	@Column(name = "Update_user")
	private String update_user;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "roles")
	private List<Resource> roleResources;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<UserInfo> users;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public List<Resource> getRoleResources() {
		return roleResources;
	}

	public void setRoleResources(List<Resource> roleResources) {
		this.roleResources = roleResources;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
