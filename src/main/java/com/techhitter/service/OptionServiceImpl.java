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

import com.techhitter.model.OptionTable;
import com.techhitter.model.QueObject;
import com.techhitter.repository.OptionsRepo;

@Service
public class OptionServiceImpl implements OptionService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OptionsRepo OptionsRepo;
	
	
	public void OptionsSave(ArrayList<String> options,Long q_id) {
		try {
			for(int i=0;i<options.size();i++) {
				OptionTable optiontable=new OptionTable();
				optiontable.setq_id(q_id);
				optiontable.setOption(options.get(i));
				OptionsRepo.save(optiontable);
			}
		} catch (Exception e) {
			logger.info("Error in Saving Options, " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> GetOptions(Long q_id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager();  
	    ArrayList<String>  l1 = new ArrayList<String>();
		try {
			Query query2 =  entitymanager.createQuery("Select o from OptionTable o where o.q_id=:q_id");
			  query2.setParameter("q_id",q_id); 
			  List<OptionTable> list3 =  (query2).getResultList();
			   
			  int i=0;
			  for(OptionTable option:list3) {
				  //l1[i]=option.getOption();
				  l1.add(option.getOption());
				i++;
			  }
		} catch (Exception e) {
			logger.info("Error in Getting Option, " + e.getMessage());
			e.printStackTrace();
		}
	    return l1;
	}
	

}
