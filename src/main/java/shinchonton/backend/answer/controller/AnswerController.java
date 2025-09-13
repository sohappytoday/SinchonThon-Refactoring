package shinchonton.backend.answer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.answer.dto.request.AnswerRequest;
import shinchonton.backend.answer.dto.response.AnswerResponse;
import shinchonton.backend.answer.service.AnswerService;
import shinchonton.backend.department.dto.DepartmentResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/1")
    public ResponseEntity<List<AnswerResponse>> getFirstAnswers() {
        List<AnswerResponse> answers = answerService.getFirstAnswers();
        return ResponseEntity.ok(answers);
    }

    @PostMapping("/1")
    public ResponseEntity<List<AnswerResponse>> saveFirstAnswerAndGetSecond(
            @RequestBody AnswerRequest request,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId) {

        List<AnswerResponse> nextAnswers = answerService.saveFirstAnswerAndGetNext(userId, request.getAnswerId());
        return ResponseEntity.ok(nextAnswers);
    }

    @PostMapping("/2")
    public ResponseEntity<List<AnswerResponse>> saveSecondAnswerAndGetNext(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestBody AnswerRequest request
    ) {
        List<AnswerResponse> answers = answerService.saveSecondAnswerAndGetNext(userId, request.getAnswerId());
        return ResponseEntity.ok(answers);
    }

    @PostMapping("/3")
    public ResponseEntity<List<AnswerResponse>> saveThirdAnswerAndGetNext(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestBody AnswerRequest request
    ) {
        List<AnswerResponse> answers = answerService.saveThirdAnswerAndGetNext(userId, request.getAnswerId());
        return ResponseEntity.ok(answers);
    }

    @PostMapping("/4")
    public ResponseEntity<List<DepartmentResponse>> saveFourthAnswerAndGetDepartmets(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestBody AnswerRequest request
    ) {
        List<DepartmentResponse> majors = answerService.saveFourthAnswerAndGetDepartments(userId, request.getAnswerId());
        return ResponseEntity.ok(majors);
    }




}

