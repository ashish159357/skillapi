package com.techhitter.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhitter.model.QueObject;
import com.techhitter.model.QuetionTable;
import com.techhitter.repository.QuetionRepo;

@Service
public class QuestionServiceImpl implements QuetionService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QuetionRepo Quetionrepo;
	
	@Autowired
	private OptionService optionApiService;
	
	@Autowired
	private AnswerService answerApiService;
	
	
	//@Override
	public QuetionTable QuestionSave(QueObject qo) {
		QuetionTable quetiontable=new QuetionTable();
		try {
			quetiontable.setQue(qo.getQue());
			quetiontable.setSubject(qo.getSubject());
			quetiontable.setType(qo.isType());
			Quetionrepo.save(quetiontable);
		} catch (Exception e) {
			logger.info("Error in Saving Quetion, " + e.getMessage());
			e.printStackTrace();
		}
		return quetiontable;
	}
	
	public List<QueObject> GetQuetion(String ss) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager();  
	    List<QueObject> listQue = new ArrayList<QueObject>();;
		try {
			  Query query =  entitymanager.createQuery("Select q from QuetionTable q where q.subject=:ss");
			  query.setParameter("ss",ss);
			  List<QuetionTable> list =  (query).getResultList();
			  
			  for(QuetionTable fruit:list) {  
				  QueObject ob=new QueObject();
				  ob.setQue(fruit.getQue());
				  ob.setType(fruit.getType());
				  ob.setSubject(fruit.getSubject());
				  ob.setOptions(optionApiService.GetOptions(fruit.getQ_id()));
				  ob.setAns(answerApiService.GetAnswer(fruit.getQ_id()));
				  listQue.add(ob); 
			  }
		} catch (Exception e) {
			logger.info("Error in Getting Quetion, " + e.getMessage());
			e.printStackTrace();
		}
        return listQue;
	}
	
	
}
