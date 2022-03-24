package org.diembo.web;

import org.diembo.msg.QuestionnaireResponse;
import org.diembo.service.api.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/desc")
public class _DeskController {
	
	@GetMapping("/403")
	private String accessDenied() {
		return "<h2>403</h2>";
	}
	
	@GetMapping("/")
	private String home() {
		return "<h2>Home</h2>";
	}
	
	@GetMapping("/questionnaires")
	private QuestionnaireResponse getQuestionnaires() {
		return questionnaireService.getQuestionnaires();
	}
	@GetMapping("/questionnaire/{id}")
	private QuestionnaireResponse getQuestionnaire(@PathVariable Long id) {
		return questionnaireService.getQuestionnaire(id);
	}
	@Autowired
	private QuestionnaireService questionnaireService;

}
