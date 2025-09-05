package shinchonton.backend.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.answer.domain.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Optional<Answer> findByAnswerContent(String answerContent);
    List<Answer> findByPrev1IdAndPrev2IdIsNull(Long prev1Id);
}