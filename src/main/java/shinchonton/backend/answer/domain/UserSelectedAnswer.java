package shinchonton.backend.answer.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shinchonton.backend.user.domain.User;

@Entity
@Table(name = "user_selected_answer")
@Getter
@NoArgsConstructor
public class UserSelectedAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User FK
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    // Answer FK
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    private UserSelectedAnswer(User user, Answer answer) {
        this.user = user;
        this.answer = answer;
    }

    public static UserSelectedAnswer userSelected(User user, Answer answer){
        return new UserSelectedAnswer(user, answer);
    }
}
