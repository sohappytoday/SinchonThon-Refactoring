package shinchonton.backend.answer.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answer")
@Getter
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prev_id")
    private Answer prevAnswer;

    @OneToMany(mappedBy = "prevAnswer")
    private List<Answer> nextAnswers = new ArrayList<>();

    private Answer(String content) {
        this.content = content;
    }

    public static Answer createAnswer(String content, Answer prevAnswer){
        //id와 content 를 주입
        Answer answer = new Answer(content);
        //prevAnswer field에 prevAnswer 추가
        answer.prevAnswer = prevAnswer;
        //prevAnswer의 nextAnswer List에 create할 answer 추가
        prevAnswer.nextAnswers.add(answer);

        return answer;
    }
}