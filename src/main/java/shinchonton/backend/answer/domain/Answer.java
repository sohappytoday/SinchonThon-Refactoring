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
    private String prevId;

    @Column
    private String answerContent;
}