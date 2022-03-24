package org.diembo.msg;

import java.util.List;

import org.diembo.dto.QuestionnaireDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class QuestionnaireResponse {
	
	private QuestionnaireDto questionnaireDto;
	private List<QuestionnaireDto> questionnaireDtos;
	public QuestionnaireDto getQuestionnaireDto() {
		return questionnaireDto;
	}
	public void setQuestionnaireDto(QuestionnaireDto questionnaireDto) {
		this.questionnaireDto = questionnaireDto;
	}
	public List<QuestionnaireDto> getQuestionnaireDtos() {
		return questionnaireDtos;
	}
	public void setQuestionnaireDtos(List<QuestionnaireDto> questionnaireDtos) {
		this.questionnaireDtos = questionnaireDtos;
	}
	
	
}
