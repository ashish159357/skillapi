package com.techhitter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quetion_table")
public class QuetionTable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=" id")
	private Long q_id;

	private String que;

	private String subject;

	private boolean que_type;

	public boolean getType() {
		return que_type;
	}

	public void setType(boolean type) {
		this.que_type = type;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getQ_id() {
		return q_id;
	}

	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}
	
	@Override
	public String toString() {
		return "QuetionTable [q_id=" + q_id + ", que=" + que + ", subject=" + subject + ", type=" + que_type + "]";
	}
}
