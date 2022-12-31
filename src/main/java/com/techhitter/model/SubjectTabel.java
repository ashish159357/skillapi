package com.techhitter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class SubjectTabel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sub_id;
	//private Long q_id;
	private String subject;
	
	
	public Long getSub_id() {
		return sub_id;
	}
	public void setSub_id(Long sub_id) {
		this.sub_id = sub_id;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "SubjectTabel [sub_id=" + sub_id + "," + ", subject=" + subject + "]";
	}
	
	
	

}
