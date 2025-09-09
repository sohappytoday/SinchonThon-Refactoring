package shinchonton.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.user.domain.Mentee;

import java.util.Optional;

public interface MenteeRepository extends JpaRepository<Mentee, Long> {
    Optional<Mentee> findByUserId(Long userId);
}
