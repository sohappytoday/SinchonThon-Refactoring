package shinchonton.backend.token.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> logout(@RequestAttribute(name = TokenAuthenticationFilter.ATTR_SESSION_ID,required = false)Long token_id) {
        if (token_id == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        authService.logout(token_id);
        return ResponseEntity.status(HttpStatus.SEE_OTHER) // 303
                .header(HttpHeaders.LOCATION, "/mock-login.html") // 리다이렉트 경로
                .body("로그아웃 잘 되었습니다.");
    }

}
