package shinchonton.backend.answer.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.major.domain.Major;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "answers3")
    private List<Major> majors = new ArrayList<>();
}