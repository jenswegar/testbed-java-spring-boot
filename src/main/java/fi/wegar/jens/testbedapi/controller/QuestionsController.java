package fi.wegar.jens.testbedapi.controller;

import fi.wegar.jens.testbedapi.api.QuestionsApi;
import fi.wegar.jens.testbedapi.entity.QuestionEntity;
import fi.wegar.jens.testbedapi.mapper.QuestionMapper;
import fi.wegar.jens.testbedapi.model.Question;
import fi.wegar.jens.testbedapi.model.QuestionRequest;
import fi.wegar.jens.testbedapi.repository.QuestionRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@BasePathAwareController
@RestController
public class QuestionsController implements QuestionsApi {
    protected QuestionRepository repository;

    @Autowired
    public QuestionsController(QuestionRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Question>> getQuestions(){

        List<Question> rtn = new ArrayList<>();
        repository.findAll().forEach((q) -> {
            rtn.add(QuestionMapper.INSTANCE.toAPI(q));
        });

        return ResponseEntity.ok().body(rtn);
    }

    public ResponseEntity<Question> getQuestion(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {

        Optional<QuestionEntity> q = repository.findById(id);

        if(q.isPresent()){
            return ResponseEntity.ok().body(QuestionMapper.INSTANCE.toAPI(q.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Question> getRandomQuestion() {
        Question q = new Question().id(123L).text("lorem ipsum random");

        return ResponseEntity.ok().body(q);
    }

    public ResponseEntity<Question> createQuestion(@ApiParam(value = "Create a new question" ,required=true )  @Valid @RequestBody QuestionRequest questionRequest) {
        QuestionEntity qe = QuestionMapper.INSTANCE.toEntity(questionRequest);

        qe = repository.save(qe);

        return ResponseEntity.ok().body(QuestionMapper.INSTANCE.toAPI(qe));
    }

    public ResponseEntity<Question> updateQuestion(@Min(1L) @ApiParam(value = "",required = true) @PathVariable("id") Long id, @ApiParam(value = "Update an existing question",required = true) @Valid @RequestBody QuestionRequest questionRequest) {
        QuestionEntity qe = QuestionMapper.INSTANCE.toEntity(questionRequest);
        qe.setId(id);

        qe = repository.save(qe);

        return ResponseEntity.ok().body(QuestionMapper.INSTANCE.toAPI(qe));
    }

    public ResponseEntity<Void> deleteQuestion(@Min(1L) @ApiParam(value = "",required = true) @PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
