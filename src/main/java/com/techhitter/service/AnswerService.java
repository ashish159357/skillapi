package com.techhitter.service;

import java.util.ArrayList;

public interface AnswerService {
	
	public void AnswerSave(ArrayList<String> answers,Long q_id);
	
	public ArrayList<String> GetAnswer(Long q_id);

}
