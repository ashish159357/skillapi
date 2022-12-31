package com.techhitter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="option_table")
public class OptionTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long o_id;
	private Long q_id;
	private String option;
	
	//@ManyToOne(cascade= CascadeType.ALL)
    //@JoinColumn(name = "q_id")
    //private QuetionTable quetiontables;

	public Long getq_id() {
		return q_id;
	}

	public void setq_id(Long q_id) {
		this.q_id = q_id;
	}

	public Long getO_id() {
		return o_id;
	}

	public void setO_id(Long o_id) {
		this.o_id = o_id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	/*public QuetionTable getQuetiontables() {
		return quetiontables;
	}

	public void setQuetiontables(QuetionTable quetiontables) {
		this.quetiontables = quetiontables;
	}*/

}
