package shinchonton.backend.token.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.dto.request.LoginRequest;
import shinchonton.backend.token.dto.response.LoginResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;
import shinchonton.backend.token.service.AuthService;
import shinchonton.backend.token.service.TokenService;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class AuthController {

    private final AuthService authService;
    private final TokenService tokenService;

    // 1) 로그인: AT + RT
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) {
        return ResponseEntity.ok(authService.login(req));
    }


    // 3) 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_SESSION_ID, required = false) Long tokenId) {

        if (tokenId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.<Void>builder()
                            .success(false)
                            .code(HttpStatus.UNAUTHORIZED.value())
                            .message("유효하지 않은 세션입니다.")
                            .build());
        }

        authService.logout(tokenId);

        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .code(HttpStatus.OK.value())
                        .message("로그아웃 성공")
                        .build()
        );
    }


}