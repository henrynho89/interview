package org.diembo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Entity
public class AppRole extends GenericEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@ManyToOne
	@JoinColumn(name = "PROFILE_ID", foreignKey=@ForeignKey(name="FK_ROLE_PROFILE_R_PROFILE"), nullable = false)
	public Profile profile;

	@Column(name = "ROLE_CODE", length=30, nullable = false)
	protected String roleCode;

	@Column(name = "NAME", length=140, nullable = false)
	protected String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<RolePerson> rolePersons;
	

	
	public List<RolePerson> getRolePersons() {
		return rolePersons;
	}



	public void setRolePersons(List<RolePerson> rolePersons) {
		this.rolePersons = rolePersons;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Profile getProfile() {
		return profile;
	}



	public void setProfile(Profile profile) {
		this.profile = profile;
	}



	public String getRoleCode() {
		return roleCode;
	}



	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	private static final long serialVersionUID = 1L;



	@Override
	public void setIdToNull() {
		// TODO Auto-generated method stub
		
	}

}
