package com.techhitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techhitter.model.AnswerTable;



public interface AnswerRepo extends JpaRepository<AnswerTable,String>{

}
