package com.techhitter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.techhitter.model.QueObject;
import com.techhitter.model.QuetionTable;
import com.techhitter.model.SubjectTabel;
import com.techhitter.service.AnswerService;
import com.techhitter.service.OptionService;
import com.techhitter.service.QuetionService;
import com.techhitter.service.SubjectService;


@RestController
@CrossOrigin(origins = "*")
public class HandleController {
	
	@Autowired
	private QuetionService quetionApiService; 
	
	@Autowired
	private OptionService optionApiService; 
	
	@Autowired
	private AnswerService answerApiService;

	@Autowired
	private SubjectService SubjectApiService;

	@GetMapping("/api/v1/index")
	public String index(QueObject qo) {
		return "index.jsp";
	}
	
	@GetMapping("/api/v1/subjects")
	 List<SubjectTabel> subjects() {	
		return SubjectApiService.subjects();
	}

	@PostMapping("/api/v1/AddQue")
    void addQuetion(@RequestBody QueObject qo) {
		QuetionTable quetiontable = quetionApiService.QuestionSave(qo);
		optionApiService.OptionsSave(qo.getOptions(),quetiontable.getQ_id());
		answerApiService.AnswerSave(qo.getAns(), quetiontable.getQ_id());
    }

	@GetMapping("/api/v1/quetions/{su}")
	List<QueObject> getQuetion(@PathVariable(value = "su") String ss){
		List<QueObject> listQue = quetionApiService.GetQuetion(ss);
		return listQue;
	}
}
