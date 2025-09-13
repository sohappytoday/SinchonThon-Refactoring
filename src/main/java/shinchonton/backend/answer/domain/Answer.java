package shinchonton.backend.answer.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answer")
@Getter
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prev_id") // FK 컬럼명
    private Answer prevAnswer;

    private Answer(Answer answer){
        this.prevAnswer = answer;
    }

    public static Answer createAnswer(Answer answer){
        return new Answer(answer);
    }

}