package org.diembo.manager.api;

import java.util.List;

import org.diembo.entities.Questionnaire;

public interface QuestionnaireManager {

	public List<Questionnaire> getQuestionnaires();
	public Questionnaire getQuestionnaire(Long id);
}
