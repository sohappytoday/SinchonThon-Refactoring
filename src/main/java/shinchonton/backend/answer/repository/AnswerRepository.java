package shinchonton.backend.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.answer.domain.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    //AnswerId로 Id 찾기
    Optional<Answer> findById(Long id);

    //Answer 존재 여부
    boolean existsById(Long id);

    //prev_Id로 Answer List 찾기
    List<Answer> findAllByPrevAnswerId(Long prevAnswerId);
}