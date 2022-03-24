package org.diembo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

@Entity
public class Profile extends GenericEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PROFILE_CODE", length=30, nullable=false)
	private String profileCode;
	public void setProfileCode(String value) {
		this.profileCode = value;
	}
	public String getProfileCode(){
		return this.profileCode;
	}


	@Column(name = "NAME", length=140, nullable=false)
	private String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}

	// .---------------------------------------------------------------------------. //


	private static final long serialVersionUID = 1L;
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setIdToNull() {
		// TODO Auto-generated method stub
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	// .---------------------------------------------------------------------------. //

}
