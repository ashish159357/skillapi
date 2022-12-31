package com.techhitter.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

import com.techhitter.model.AnswerTable;
import com.techhitter.repository.AnswerRepo;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AnswerRepo AnswerRepo;
	
	
	public void AnswerSave(ArrayList<String> answers,Long q_id) {
		try {
			for(int j=0;j<answers.size();j++) {
				AnswerTable answertable=new AnswerTable(); 
				answertable.setQuetion_id(q_id);
				answertable.setAnswer(answers.get(j));
				AnswerRepo.save(answertable);
			}
		} catch (Exception e) {
			logger.info("Error in Saving Answer, " + e.getMessage());
			e.printStackTrace();
		}
	}

	public ArrayList<String> GetAnswer(Long q_id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager();
		ArrayList<String>  l2 = new ArrayList<String>();
		try {
			  Query query3 =  entitymanager.createQuery("Select a from AnswerTable a where a.q_id=:q_id");
			  query3.setParameter("q_id",q_id);
			  List<AnswerTable> list4 =  (query3).getResultList();
			  int j=0;
			  for(AnswerTable answer:list4) {
				  //l2[j]=answer.getAnswer();
				  l2.add(answer.getAnswer());
				j++;
			  }
		} catch (Exception e) {
			logger.info("Error in Getting Answer, " + e.getMessage()); 
			e.printStackTrace();
		}
	    return l2;
	}
	
}
