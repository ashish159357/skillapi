package com.techhitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhitter.model.SubjectTabel;
import com.techhitter.repository.SubjectRepo;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepo SubjectRepo;
	

	public List<SubjectTabel> subjects(){
		return SubjectRepo.findAll();
	}
	
}
