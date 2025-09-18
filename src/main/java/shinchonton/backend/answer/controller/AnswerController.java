package shinchonton.backend.answer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.answer.dto.request.AnswerRequest;
import shinchonton.backend.answer.dto.response.AnswerResponse;
import shinchonton.backend.answer.service.AnswerService;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.department.dto.DepartmentResponse;
import shinchonton.backend.department.service.DepartmentService;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;

import java.util.List;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final DepartmentService departmentService;

    //첫 번째 질문 보여주기
    @GetMapping
    public ResponseEntity<ApiResponse<List<AnswerResponse>>> showFirstAnswerList() {
        List<AnswerResponse> answerResponseList = answerService.showFirstAnswerList();

        return ResponseEntity.ok(ApiResponse.success("다음 답변 리스트 보기 성공", answerResponseList));
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<ApiResponse<List<AnswerResponse>>> showNextAnswerList(@PathVariable Long answerId) {
        List<AnswerResponse> answerResponseList = answerService.showNextAnswerList(answerId);

        return ResponseEntity.ok(ApiResponse.success("다음 답변 리스트 보기 성공", answerResponseList));
    }

    @GetMapping("/{answerId}/departments")
    public ResponseEntity<ApiResponse<List<DepartmentResponse>>> showLastAnswerList(@PathVariable Long answerId) {
        List<DepartmentResponse> departmentResponseList = departmentService.showDepartmentListByAnswerId(answerId);

        return ResponseEntity.ok(ApiResponse.success("학과 카드 리스트 보기 성공", departmentResponseList));
    }



}

