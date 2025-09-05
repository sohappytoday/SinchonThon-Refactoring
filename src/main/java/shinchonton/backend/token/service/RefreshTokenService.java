package shinchonton.backend.token.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.token.domain.RefreshToken;
import shinchonton.backend.token.repository.RefreshTokenRepository;

import java.time.Instant;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    // refresh token 디비 존재 여부 + 만료(Expired) + 철회(Revoked) 검증 수행
    public RefreshToken getActiveByTokenOrThrow(String refreshToken) {
        RefreshToken rt = refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow();

        return rt;
    }

    @Transactional
    public void revokeById(Long sid) {
        refreshTokenRepository.findById(sid).ifPresent(rt -> {
            if (!rt.isRevoked()) rt.setRevoked(true); // 변경감지로 UPDATE
        });
    }
}

