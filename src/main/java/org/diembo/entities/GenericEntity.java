package org.diembo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {
	// ------------------------------------------------------- //
	// ------------------------------------------------------- //
	@Column(name = "LASTUPDATE", nullable=false)@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	// -----------------------//
	@Column(name = "USER_CODE", nullable=false, length = 30)
	private String userCode;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	// -----------------------//
	@Column(name = "VERSION", nullable=false)
	private Long version;
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	// ------------------------------------------------------- //
	
	
	// ------------------------------------------------------- //
	// ------------------------------------------------------- //
	public abstract Long getId();
	public abstract void setIdToNull();
	// ------------------------------------------------------- //
	
	
	// ------------------------------------------------------- //
	
	
	// ------------------------------------------------------- //
	private static final long serialVersionUID = 1L ;
	// ------------------------------------------------------- //
}
