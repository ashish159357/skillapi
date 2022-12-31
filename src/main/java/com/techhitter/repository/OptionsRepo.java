package com.techhitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techhitter.model.OptionTable;


public interface OptionsRepo extends JpaRepository<OptionTable,String>{

}
