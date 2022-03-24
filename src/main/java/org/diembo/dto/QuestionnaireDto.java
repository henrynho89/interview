package org.diembo.dto;

import java.util.Date;
import java.util.List;

import org.diembo.entities.Questionnaire;
import org.diembo.entities.QuestionnaireVersion;

public class QuestionnaireDto {
	
	private Long id;
	private String code;
	private String description;
	private Integer dontShowOverridePeriod;
    private Date dontShowOverrideDate;
	private List<QuestionnaireVersion>	questionnaireVersions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDontShowOverridePeriod() {
		return dontShowOverridePeriod;
	}
	public void setDontShowOverridePeriod(Integer dontShowOverridePeriod) {
		this.dontShowOverridePeriod = dontShowOverridePeriod;
	}
	public Date getDontShowOverrideDate() {
		return dontShowOverrideDate;
	}
	public void setDontShowOverrideDate(Date dontShowOverrideDate) {
		this.dontShowOverrideDate = dontShowOverrideDate;
	}
	public List<QuestionnaireVersion> getQuestionnaireVersions() {
		return questionnaireVersions;
	}
	public void setQuestionnaireVersions(List<QuestionnaireVersion> questionnaireVersions) {
		this.questionnaireVersions = questionnaireVersions;
	}
	
	public QuestionnaireDto init(Questionnaire questionnaire) {
		QuestionnaireDto questionnaireDto = new QuestionnaireDto();
		questionnaireDto.setId(questionnaire.getId());
		questionnaireDto.setCode(questionnaire.getCode());
		questionnaireDto.setDescription(questionnaire.getDescription());
		questionnaireDto.setDontShowOverrideDate(questionnaire.getDontShowOverrideDate());
		questionnaireDto.setDontShowOverridePeriod(questionnaire.getDontShowOverridePeriod());
		
		if(questionnaire.getQuestionnaireVersions()!=null)	questionnaireDto.setQuestionnaireVersions(questionnaire.getQuestionnaireVersions()); 
		
		return questionnaireDto;
	}
	
	
}
