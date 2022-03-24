package org.diembo.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

@Entity
public class Person extends GenericEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FIRST_NAME", length=140, nullable = false)
	private String firstName;

	@Column(length=140, nullable = false,unique = true)
	private String login;
	
	@Column(nullable = false)
	private String password;
	
	@Column(name = "LAST_NAME", length=140, nullable = false)
	private String lastName;
	
	@Column(name = "EMAIL", length=60)
	private String email;
	
	@Column(name = "PHONE", length=30)
	private String phone;
	
	@Column(name = "DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private java.util.Date dateOfBirth;
	
	@Column(nullable = false)
	private Boolean active;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<RolePerson> rolePersons;
	
	@Transient
	private List<AppRole> role;
	

	public List<AppRole> getRole() {
		return role;
	}
	public void setRole(List<AppRole> role) {
		this.role = role;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<RolePerson> getRolePersons() {
		return rolePersons;
	}
	public void setRolePersons(List<RolePerson> rolePersons) {
		this.rolePersons = rolePersons;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDateOfBirth(java.util.Date value) {
		this.dateOfBirth = value;
	}
	public java.util.Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setPhone(String value) {
		this.phone = value;
	}
	public String getPhone() {
		return this.phone;
	}

	
	public void setEmail(String value) {
		this.email = value;
	}
	public String getEmail() {
		return this.email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setIdToNull() {
		
	}



	private static final long serialVersionUID = 1L;


}
