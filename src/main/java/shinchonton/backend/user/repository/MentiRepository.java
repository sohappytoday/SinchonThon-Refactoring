package shinchonton.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.user.domain.Menti;

import java.util.Optional;

public interface MentiRepository extends JpaRepository<Menti, Long> {
    Optional<Menti> findByUserId(Long userId);
}
