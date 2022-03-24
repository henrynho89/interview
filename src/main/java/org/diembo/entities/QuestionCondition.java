package org.diembo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "QUESTION_CONDITION")
public class QuestionCondition extends GenericEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable=false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@ManyToOne
	@JoinColumn(name="CONDITIONNING_QUESTION_ID")
	private Question conditionningQuestion;
	
	@Column(name = "MIN_GRADE")
	private Double minGrade;
	
	@Column(name = "MAX_GRADE")
	private Double maxGrade;
	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Question getConditionningQuestion() {
		return conditionningQuestion;
	}

	public void setConditionningQuestion(Question conditionningQuestion) {
		this.conditionningQuestion = conditionningQuestion;
	}

	public Double getMinGrade() {
		return minGrade;
	}

	public void setMinGrade(Double minGrade) {
		this.minGrade = minGrade;
	}

	public Double getMaxGrade() {
		return maxGrade;
	}

	public void setMaxGrade(Double maxGrade) {
		this.maxGrade = maxGrade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setIdToNull() {
		
	}
	
	
}
