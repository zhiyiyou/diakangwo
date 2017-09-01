package com.diankangwo.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息表
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "UserInfo")
@Table(name = "td_userinfo")
public class UserInfo implements UserDetails {

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
	 * 用户名
	 */
	@Column(name = "username")
	private String username;
	/**
	 * token
	 */
	@Column(name = "accessToken")
	private String accessToken;
	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;
	/**
	 * 是否启用
	 */
	@Column(name = "enabled")
	private boolean enabled = false;
	/**
	 * 加密盐值
	 */
	@Column(name = "salt_value")
	private String salt_value;
	/**
	 * 头像
	 */
	@Column(name = "profileImageUrl")
	private String profileImageUrl;
	/**
	 * 昵称
	 */
	@Column(name = "nickname")
	private String nickname;
	/**
	 * 性别
	 */
	@Column(name = "gender")
	private Boolean gender = true;
	/**
	 * 手机号
	 */
	@Column(name = "tel")
	private String tel;
	/**
	 * 电子邮箱
	 */
	@Column(name = "email")
	private String email;
	/**
	 * 默认收货地址
	 */
	@Column(name = "defaultAddress")
	private String defaultAddress;
	/**
	 * 余额
	 */
	@Column(name = "balance")
	private Long balance;
	/**
	 * 自我介绍
	 */
	@Column(name = "description")
	private String description;

	/**
	 * 所属用户
	 */
	@Column(name = "userGroup")
	private Integer userGroup;

	/**
	 * getui_cid
	 */
	@Column(name = "getui_cid")
	private String getui_cid;

	/**
	 * 积分
	 */
	@Column(name = "integral")
	private String integral;

	/**
	 * 注册时间
	 */
	@Column(name = "createdAt")
	private Date createdAt;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "td_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		for (Role role : getRoles()) {
			list.add(new SimpleGrantedAuthority(role.getRole_name()));
		}
		return list;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSalt_value() {
		return salt_value;
	}

	public void setSalt_value(String salt_value) {
		this.salt_value = salt_value;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(String defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(Integer userGroup) {
		this.userGroup = userGroup;
	}

	public String getGetui_cid() {
		return getui_cid;
	}

	public void setGetui_cid(String getui_cid) {
		this.getui_cid = getui_cid;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
