package org.diembo.service.api;

import org.diembo.msg.QuestionnaireResponse;

public interface QuestionnaireService {
	
	public QuestionnaireResponse getQuestionnaires();
	public QuestionnaireResponse getQuestionnaire(Long id);

}
