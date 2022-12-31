package com.techhitter.service;

import java.util.List;

import com.techhitter.model.QueObject;
import com.techhitter.model.QuetionTable;

public interface QuetionService {
	
	public QuetionTable QuestionSave(QueObject qo);
	public List<QueObject> GetQuetion(String ss);

}
