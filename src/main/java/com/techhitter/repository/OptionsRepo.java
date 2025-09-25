package com.techhitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.techhitter.model.OptionTable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionsRepo extends JpaRepository<OptionTable,String>{
    @Query("SELECT o FROM OptionTable o WHERE o.q_id = :qId")
    List<OptionTable> findByq_id(@Param("qId") Long q_id);
}
