package shinchonton.backend.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.users.dto.request.SignUpRequest;
import shinchonton.backend.users.service.UsersService;


@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService userService;

    @PostMapping
    public ResponseEntity<String> signup(@RequestBody SignUpRequest request) {
        userService.signup(request);
        return ResponseEntity.ok("회원가입 성공");
    }
}