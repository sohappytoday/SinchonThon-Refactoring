package shinchonton.backend.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.users.domain.Mento;

import java.util.Optional;

public interface MentoRepository extends JpaRepository<Mento, Long> {
    Optional<Mento> findByUserId(Long userId);
}
