package shinchonton.backend.answer.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.users.domain.Users;

@Builder
@Setter
@Entity
@Table(name = "user_answer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer1_id")
    private Answer answer1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer2_id")
    private Answer answer2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer3_id")
    private Answer answer3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer4_id")
    private Answer answer4;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer5_id")
    private Answer answer5;

}
