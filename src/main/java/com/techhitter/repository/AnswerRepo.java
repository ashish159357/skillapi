package com.techhitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.techhitter.model.AnswerTable;

import java.util.List;

public interface AnswerRepo extends JpaRepository<AnswerTable,String>{
    @Query("SELECT a FROM AnswerTable a WHERE a.q_id = :qId")
    List<AnswerTable> findByq_id(@Param("qId") Long q_id);
}
