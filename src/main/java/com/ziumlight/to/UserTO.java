package com.ziumlight.to;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
@Table(name = "user")
public class UserTO extends BaseTO implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable=false)
    private Integer userId;

	@Column(name = "user_name", nullable=false)
    private String userName;
	
	@JsonIgnore
	@Column(name = "password", nullable=false)
    private String password;

	@Column(name = "status", nullable=true)
    private String status;

	@Column(name = "name", nullable=false)
    private String name;

	@Column(name = "email_address", nullable=true)
    private String emailAddress;

	@Column(name = "last_login", nullable=true)
    private Date lastLogin;

	@Column(name = "enabled", nullable=false)
    private char enabled;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public char getEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
}
