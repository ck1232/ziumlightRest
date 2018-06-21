package com.ziumlight.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorResponse implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	
	private int status;
	
	private String error;
	
	private String messsage;
	
	private String path;

	public ErrorResponse(Date timestamp, int status, String error, String messsage, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.messsage = messsage;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
