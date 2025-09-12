package shinchonton.backend.token.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.token.domain.RefreshToken;
import shinchonton.backend.token.dto.response.LoginResponse;
import shinchonton.backend.token.jwt.TokenProvider;
import shinchonton.backend.token.repository.RefreshTokenRepository;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.service.SignUpService;

import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshTokenService refreshTokenService;
    private final SignUpService signUpService;
    // access token은 15분 refresh token은 14일
    private static final Duration ACCESS_EXPIRES  = Duration.ofDays(5); //프론트를 위한 시간 늘리기
    private static final Duration REFRESH_EXPIRES = Duration.ofDays(14);

    // [MOD] 로그인 시 AT,RT 제공 (sid 사용 시)
    @Transactional
    public LoginResponse issueTokens(User user) {
        String refresh = tokenProvider.generateRefreshToken(user, REFRESH_EXPIRES);   // RT 생성
        Instant now = Instant.now();

        RefreshToken saved = refreshTokenRepository.save(
                new RefreshToken(user.getUserId(), refresh, now, now.plus(REFRESH_EXPIRES))
        );

        String access  = tokenProvider.generateAccessToken(user, ACCESS_EXPIRES, saved.getTokenId()); // AT 생성
        return new LoginResponse(access, refresh);
    }


    // 재발급 메서드(유효 RT로 새 AT 발급)
    public String createNewAccessToken(String refreshToken) {
        RefreshToken rt = refreshTokenService.getActiveByTokenOrThrow(refreshToken);    //RT 유효한지 체크
        User user = signUpService.findById(rt.getUserId());                               //RT로 User를 찾기
        // 기존 세션 유지: AT에 sid 로 rt.getTokenId() 포함
        return tokenProvider.generateAccessToken(user, ACCESS_EXPIRES, rt.getTokenId()); //Access token 지급
    }
}
