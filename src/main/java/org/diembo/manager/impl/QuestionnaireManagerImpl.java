package org.diembo.manager.impl;

import java.util.List;

import org.diembo.dao.QuestionnaireRepository;
import org.diembo.entities.Questionnaire;
import org.diembo.manager.api.QuestionnaireManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionnaireManagerImpl implements QuestionnaireManager {
	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@Override
	public List<Questionnaire> getQuestionnaires() {
		return questionnaireRepository.findAll();
	}

	@Override
	public Questionnaire getQuestionnaire(Long id) {
		return questionnaireRepository.getOne(id);
	}

}
