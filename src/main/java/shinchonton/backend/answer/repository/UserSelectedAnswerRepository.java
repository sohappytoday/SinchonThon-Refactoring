package shinchonton.backend.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.answer.domain.UserSelectedAnswer;
import shinchonton.backend.user.domain.User;

import java.util.Optional;

public interface UserSelectedAnswerRepository extends JpaRepository<UserSelectedAnswer, Long> {


}
