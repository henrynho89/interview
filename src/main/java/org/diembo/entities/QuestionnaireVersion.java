package org.diembo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name = "QUESTIONNAIRE_VERSION")	
public class QuestionnaireVersion extends GenericEntity
{

	// .--------..--------..--------..--------..--------..--------..--------. //
	// .--------..--------..--------..--------..--------..--------..--------. //
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setIdToNull() {
		setId(null);
	}
	// .--------..--------..--------..--------..--------..--------..--------. //
	
	// .--------..--------..--------..--------..--------..--------..--------. //
	// .--------..--------..--------..--------..--------..--------..--------. //
	@Column(name = "ID", nullable=false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODE", length=30, nullable=false)
	private String code;
	
	@Column(name = "ENABLED")
	private Boolean enabled;

	@Column(name = "ENABLED_DATE")
	private Date enabledDate;
	
	@ManyToOne
	@JoinColumn(name="QUESTIONNAIRE_ID", nullable=false)
	private Questionnaire questionnaire;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEnabledDate() {
		return enabledDate;
	}
	public void setEnabledDate(Date enabledDate) {
		this.enabledDate = enabledDate;
	}

	private static final long serialVersionUID = 1L;
}
