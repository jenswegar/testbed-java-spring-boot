package fi.wegar.jens.testbedapi.controller;

import fi.wegar.jens.testbedapi.api.QuestionsApi;
import fi.wegar.jens.testbedapi.model.Question;
import fi.wegar.jens.testbedapi.model.QuestionRequest;
import io.swagger.annotations.ApiParam;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@BasePathAwareController
@RestController
public class QuestionsController implements QuestionsApi {

    public ResponseEntity<List<Question>> getQuestions(){
        Question q = new Question().id(123L).text("lorem ipsum");

        return ResponseEntity.ok().body(Arrays.asList(q));
    }

    public ResponseEntity<Question> getQuestion(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        Question q = new Question().id(123L).text("lorem ipsum");

        return ResponseEntity.ok().body(q);
    }

    public ResponseEntity<Question> getRandomQuestion() {
        Question q = new Question().id(123L).text("lorem ipsum random");

        return ResponseEntity.ok().body(q);
    }


    public ResponseEntity<Question> createQuestion(@ApiParam(value = "Create a new question" ,required=true )  @Valid @RequestBody QuestionRequest questionRequest) {
        Question q = new Question().id(123L).text(questionRequest.getText());

        return ResponseEntity.ok().body(q);
    }

    public ResponseEntity<Question> updateQuestion(@Min(1L) @ApiParam(value = "",required = true) @PathVariable("id") Long id, @ApiParam(value = "Update an existing question",required = true) @Valid @RequestBody QuestionRequest questionRequest) {
        Question q = new Question().id(123L).text(questionRequest.getText());

        return ResponseEntity.ok().body(q);
    }

    public ResponseEntity<Void> deleteQuestion(@Min(1L) @ApiParam(value = "",required = true) @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
