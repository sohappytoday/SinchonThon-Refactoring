package shinchonton.backend.answer.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;


    @Column
    private Long prev1Id;

    @Column
    private Long prev2Id;

    @Column
    private Long prev3Id;

    @Column
    private String answerContent;
}