package shinchonton.backend.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.user.dto.request.SignUpRequest;
import shinchonton.backend.user.dto.response.SignUpResponse;
import shinchonton.backend.user.service.SignUpService;


@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class UserSignUpController {

    private final SignUpService signUpService;

    @PostMapping
    public ResponseEntity<ApiResponse<SignUpResponse>> signup(@RequestBody SignUpRequest request) {
        SignUpResponse signUpResponse = signUpService.signup(request);

        return ResponseEntity.ok(ApiResponse.success("회원가입 성공", signUpResponse));
    }
}