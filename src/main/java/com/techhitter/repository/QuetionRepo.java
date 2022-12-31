package com.techhitter.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.techhitter.*;
import com.techhitter.model.QuetionTable;

@Repository
public interface QuetionRepo extends JpaRepository<QuetionTable,String> {

	//QuetionTable q=new QuetionTable();
	//String subject=q.getSubject();
	//@Query("Select subject from QuetionTable q")
	//List<QuetionTable> findAllDistinctSubjects();
}

