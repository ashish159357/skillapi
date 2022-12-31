package com.techhitter.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techhitter.model.AnswerTable;
import com.techhitter.model.OptionTable;
import com.techhitter.model.QueObject;
import com.techhitter.model.QuetionTable;
import com.techhitter.model.SubjectTabel;
import com.techhitter.repository.AnswerRepo;
import com.techhitter.repository.OptionsRepo;
import com.techhitter.repository.QuetionRepo;
import com.techhitter.repository.SubjectRepo;
import com.techhitter.service.AnswerService;
import com.techhitter.service.OptionService;
import com.techhitter.service.QuetionService;
import com.techhitter.service.SubjectService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HandleController {
	
	@Autowired
	private QuetionService quetionApiService; 
	
	@Autowired
	private OptionService optionApiService; 
	
	@Autowired
	private AnswerService answerApiService;
	
	//@Autowired
	//SubjectRepo SubjectRepo;
	
	@Autowired
	private SubjectService SubjectApiService;
	
	
	@GetMapping("/index")
	public String index(QueObject qo) {
		return "index.jsp";
	}
	
	@GetMapping("/subjects")
	 List<SubjectTabel> subjects() {	
		return SubjectApiService.subjects();

	}
	
	@PostMapping("/AddQue")
    void addQuetion(@RequestBody QueObject qo) {
		QuetionTable quetiontable=quetionApiService.QuestionSave(qo);	
		optionApiService.OptionsSave(qo.getOptions(),quetiontable.getQ_id());
		answerApiService.AnswerSave(qo.getAns(), quetiontable.getQ_id());
    }
	
	@GetMapping("/quetions/{su}")
	List<QueObject> getQuetion(@PathVariable(value = "su") String ss){
		
		List<QueObject> listQue=quetionApiService.GetQuetion(ss);
		
		  /*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      

	      
	      Query query =  entitymanager.createQuery("Select q from QuetionTable q where q.subject=:ss");
	      query.setParameter("ss",ss);
		
	      List<QuetionTable> list =  (query).getResultList();
	      
	      
	      
	      
	      
	      List<QueObject> listQue =  new ArrayList<QueObject>();
	      
	      
	      for(QuetionTable fruit:list) {  
	    	  QueObject ob=new QueObject();
	    	  ob.setQue(fruit.getQue());
	    	  ob.setType(fruit.getType());
	    	  ob.setSubject(fruit.getSubject());
	    	  
	    	 /////////////////////////////////////////
	    	  Query query2 =  entitymanager.createQuery("Select o from OptionTable o where o.q_id=:q_id");
		      query2.setParameter("q_id",fruit.getQ_id());
		      
		       
		      List<OptionTable> list3 =  (query2).getResultList();
		      ArrayList<String> l1=new ArrayList<String>();
		      int i=0;
		      for(OptionTable option:list3) {
		    	  //l1[i]=option.getOption();
		    	  l1.add(option.getOption());
		    	i++;
		      }
		      ob.setOptions(l1);
		      
		      //////////////////////////
		      Query query3 =  entitymanager.createQuery("Select a from AnswerTable a where a.q_id=:q_id");
		      query3.setParameter("q_id",fruit.getQ_id());
		      
		       
		      List<AnswerTable> list4 =  (query3).getResultList();
		      //String[] l2=new String[4];
		      ArrayList<String> l2=new ArrayList<String>();
		      int j=0;
		      for(AnswerTable answer:list4) {
		    	  //l2[j]=answer.getAnswer();
		    	  l2.add(answer.getAnswer());
		    	j++;
		      }
		      ob.setAns(l2);
		      
		      ////////////////////////////////
		    
		      
		      listQue.add(ob); 
	      }
*/
	     
		return listQue;
	}	

}
