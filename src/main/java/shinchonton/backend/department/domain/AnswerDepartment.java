package shinchonton.backend.department.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.answer.domain.Answer;

@Entity
@Table(name = "answerDepartment")
@Getter
@NoArgsConstructor
public class AnswerDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //답변 Id (FK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    //학과 Id (FK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private AnswerDepartment(Answer answer, Department department) {
        this.answer = answer;
        this.department = department;
    }

    public static AnswerDepartment link(Answer answer, Department department) {
        return new AnswerDepartment(answer, department);
    }
}
