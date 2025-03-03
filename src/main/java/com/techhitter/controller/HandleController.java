package com.techhitter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.techhitter.model.QueObject;
import com.techhitter.model.QuetionTable;
import com.techhitter.model.SubjectTabel;
import com.techhitter.service.AnswerService;
import com.techhitter.service.OptionService;
import com.techhitter.service.QuetionService;
import com.techhitter.service.SubjectService;

/**
 * REST controller for handling various API endpoints.
 */
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

    /**
     * Endpoint to return the index page.
     *
     * @param qo QueObject parameter
     * @return String representing the index page
     */
    @GetMapping("/api/v1/index")
    public String index(QueObject qo) {
        return "index.jsp";
    }

    /**
     * Endpoint to get the list of subjects.
     *
     * @return List of SubjectTabel objects
     */
    @GetMapping("/api/v1/subjects")
    List<SubjectTabel> subjects() {
        return SubjectApiService.subjects();
    }

    /**
     * Endpoint to add a new question.
     *
     * @param qo QueObject containing the question details
     */
    @PostMapping("/api/v1/AddQue")
    void addQuetion(@RequestBody QueObject qo) {
        QuetionTable quetiontable = quetionApiService.QuestionSave(qo);
        optionApiService.OptionsSave(qo.getOptions(), quetiontable.getQ_id());
        answerApiService.AnswerSave(qo.getAns(), quetiontable.getQ_id());
    }

    /**
     * Endpoint to get questions based on the subject.
     *
     * @param ss Subject identifier
     * @return List of QueObject objects
     */
    @GetMapping("/api/v1/quetions/{su}")
    List<QueObject> getQuetion(@PathVariable(value = "su") String ss) {
        List<QueObject> listQue = quetionApiService.GetQuetion(ss);
        return listQue;
    }
}