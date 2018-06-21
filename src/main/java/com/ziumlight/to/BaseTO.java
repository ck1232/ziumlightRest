package com.ziumlight.to;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
@MappedSuperclass
/*@EntityListeners(SQLListener.class)*/
public abstract class BaseTO extends ResourceSupport implements Serializable{
	
	@JsonIgnore
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Column(name = "delete_ind", nullable=false)
	private Character deleteInd;

	@JsonIgnore
	@Column(name = "created_by", nullable=false, updatable = false)
	private String createdBy;

	@JsonIgnore
	@Column(name = "created_on", nullable=false, updatable = false)
	private Date createdOn;

	@JsonIgnore
	@Column(name = "updated_by", nullable=false)
	private String updatedBy;

	@JsonIgnore
	@Column(name = "updated_on", nullable=false)
	private Date updatedOn;

	@JsonIgnore
	@Version
	@Column(name = "version", nullable=false)
	private Integer version;
	
	public Character getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(Character deleteInd) {
		this.deleteInd = deleteInd;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
