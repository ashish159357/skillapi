package com.techhitter.service;

import java.util.ArrayList;

import com.techhitter.model.QueObject;

public interface OptionService {
	
	public void OptionsSave(ArrayList<String> options,Long q_id);
	
	public ArrayList<String> GetOptions(Long q_id);

}
