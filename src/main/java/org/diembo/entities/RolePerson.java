package org.diembo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

@Entity
@Table( name = "ROLE_PERSON")	
public class RolePerson extends GenericEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=30, nullable=false)
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID", nullable = false)
	public AppRole appRole;
	
	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
	public Person person;

	// .---------------------------------------------------------------------------. //


	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public AppRole getAppRole() {
		return appRole;
	}



	public void setAppRole(AppRole appRole) {
		this.appRole = appRole;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setIdToNull() {
		// TODO Auto-generated method stub
		
	}


}
