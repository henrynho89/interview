package org.diembo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer extends GenericEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "ID", nullable=false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION", length=255)
	private String description;
	
	@Column(name = "RANK", length=30)
	private Integer rank;
	
	@Column(name = "GRADE", length=30)
	private Double grade;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@Column(name = "USER_INPUT_REQUIRED")
	private Boolean user_input_required;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdToNull() {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Boolean getUser_input_required() {
		return user_input_required;
	}

	public void setUser_input_required(Boolean user_input_required) {
		this.user_input_required = user_input_required;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
