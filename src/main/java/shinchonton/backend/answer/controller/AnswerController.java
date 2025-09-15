package shinchonton.backend.answer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.answer.dto.request.AnswerRequest;
import shinchonton.backend.answer.dto.response.AnswerResponse;
import shinchonton.backend.answer.service.AnswerService;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.department.dto.DepartmentResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;

import java.util.List;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<ApiResponse<List<AnswerResponse>>> showNextAnswerList(@RequestBody AnswerRequest answerRequest) {
        Long AnswerId = answerRequest.getAnswerId();
        List<AnswerResponse> answerResponseList = answerService.showNextAnswerList(AnswerId);

        return ResponseEntity.ok(ApiResponse.success("다음 답변 리스트 보기 성공", answerResponseList));
    }

    @PostMapping("/last")
    public ResponseEntity<ApiResponse<List<AnswerResponse>>> showLastAnswerList(@RequestBody AnswerRequest answerRequest,
                                                                                @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID)Long userId) {

    }


}

