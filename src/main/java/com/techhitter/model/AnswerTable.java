package com.techhitter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name="answer_table")
public class AnswerTable {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long a_id;
	private Long q_id;
    private String answer;

    public Long getQuetion_id() {
		return q_id;
	}

	public void setQuetion_id(Long q_id) {
		this.q_id = q_id;
	}

    @Override
	public String toString() {
		return "AnswerTable [a_id=" + a_id + ", q_id=" + q_id + ", answer=" + answer + "]";
	}
}
