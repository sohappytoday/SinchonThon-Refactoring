package shinchonton.backend.token.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.token.dto.request.LoginRequest;
import shinchonton.backend.token.dto.response.LoginResponse;
import shinchonton.backend.token.exception.InvalidPasswordException;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.repository.UserRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final RefreshTokenService refreshTokenService;

    @Transactional
    public LoginResponse login(LoginRequest req) {
        User user = userRepository.findByAccount(req.account())    //account로 찾기
                .orElseThrow();

        if (!passwordEncoder.matches(req.password(), user.getPassword())) {     //user의 password와 받은 password 매치
            throw new InvalidPasswordException();
        }

        return tokenService.issueTokens(user);
    }

    @Transactional
    public void logout(Long sid) {
        if (sid == null) return; // idempotent
        refreshTokenService.revokeById(sid);
    }

}

