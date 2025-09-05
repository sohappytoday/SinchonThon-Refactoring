package shinchonton.backend.answer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.dto.request.Answer1Request;
import shinchonton.backend.answer.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/1")
    public ResponseEntity<List<Answer>> getSecondAnswers(@RequestBody Answer1Request request) {
        Long answerId = request.getAnswerId();  // DTO에서 꺼내오기
        List<Answer> answers = answerService.getSecondAnswers(answerId);
        return ResponseEntity.ok(answers);
    }

//    @PostMapping("/2")

}

