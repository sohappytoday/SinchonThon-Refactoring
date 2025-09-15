package shinchonton.backend.application.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.user.domain.User;

@Entity
@Table(name = "application")
@Getter
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    // 신청 보낸 사람 (멘티)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    // 신청 받은 사람 (멘토)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    private Application(User sender, User receiver){
        this.receiver = receiver;
        this.sender = sender;
    }

    public static Application of(User sender, User receiver){
        return new Application(sender,receiver);
    }


}