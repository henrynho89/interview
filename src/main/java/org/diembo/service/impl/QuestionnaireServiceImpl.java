package org.diembo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.diembo.dto.QuestionnaireDto;
import org.diembo.entities.Questionnaire;
import org.diembo.manager.api.QuestionnaireManager;
import org.diembo.msg.QuestionnaireResponse;
import org.diembo.service.api.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{
	@Autowired
	private QuestionnaireManager questionnaireManager;
	
	@Override
	public QuestionnaireResponse getQuestionnaires() {
		List<QuestionnaireDto> questionnaireDtos = new ArrayList<QuestionnaireDto>();
		for (Questionnaire questionnaire : questionnaireManager.getQuestionnaires()) {
			QuestionnaireDto questionnaireDto = new QuestionnaireDto();
			questionnaireDto = questionnaireDto.init(questionnaireManager.getQuestionnaire(questionnaire.getId()));
			if(questionnaireDto != null)		questionnaireDtos.add(questionnaireDto);
		}
		
		QuestionnaireResponse response = new QuestionnaireResponse();
		response.setQuestionnaireDtos(questionnaireDtos);
		
		return response;
	}

	@Override
	public QuestionnaireResponse getQuestionnaire(Long id) {
		QuestionnaireDto questionnaireDto = new QuestionnaireDto();
		questionnaireDto = questionnaireDto.init(questionnaireManager.getQuestionnaire(id));
		
		QuestionnaireResponse response = new QuestionnaireResponse();
		response.setQuestionnaireDto(questionnaireDto);
		
		return response;
	}

}
