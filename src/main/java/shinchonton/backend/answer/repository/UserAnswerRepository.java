package shinchonton.backend.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.answer.domain.UserAnswer;
import shinchonton.backend.user.domain.User;

import java.util.Optional;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    Optional<UserAnswer> findByUser(User user);
}
