package com.techhitter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhitter.model.AnswerTable;
import com.techhitter.repository.AnswerRepo;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AnswerRepo AnswerRepo;
	
	
	public void AnswerSave(ArrayList<String> answers, Long q_id) {
		try {
			List<AnswerTable> answerTables = answers.stream()
					.map(answer -> {
						AnswerTable answerTable = new AnswerTable();
						answerTable.setQuetion_id(q_id);
						answerTable.setAnswer(answer);
						return answerTable;
					})
					.collect(Collectors.toList());

			AnswerRepo.saveAll(answerTables);
			logger.info("Successfully saved {} answers for question ID: {}", answers.size(), q_id);
		} catch (Exception e) {
			logger.error("Error in Saving Answer for question ID: {}, Error: {}", q_id, e.getMessage());
			e.printStackTrace();
		}
	}

	public ArrayList<String> GetAnswer(Long q_id) {
		ArrayList<String> answers = new ArrayList<>();
		try {
			List<AnswerTable> answerTables = AnswerRepo.findByq_id(q_id);
			answers = answerTables.stream()
					.map(AnswerTable::getAnswer)
					.collect(Collectors.toCollection(ArrayList::new));
		} catch (Exception e) {
			logger.error("Error in Getting Answer for question ID: {}, Error: {}", q_id, e.getMessage());
			e.printStackTrace();
		}
		return answers;
	}
	
}
