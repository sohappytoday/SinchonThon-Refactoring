package shinchonton.backend.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.department.domain.AnswerDepartment;

import java.util.List;

public interface AnswerDepartmentRepository extends JpaRepository<AnswerDepartment,Long> {
    List<AnswerDepartment> findAllByAnswer(Answer answer);
}
