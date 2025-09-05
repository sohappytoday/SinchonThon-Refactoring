package shinchonton.backend.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.token.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findById(Long id);      //특정 사용자의 RefreshToken을 찾을 때
    Optional<RefreshToken> findByRefreshToken(String refreshToken);    //특정 RefreshToken이 DB에 저장이 되어있는지 찾을 때
}
