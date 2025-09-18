package shinchonton.backend.application.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;
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
    private Mentee sender;

    // 신청 받은 사람 (멘토)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    private Mentor receiver;

    private Application(Mentee sender, Mentor receiver){
        this.receiver = receiver;
        this.sender = sender;
    }

    public static Application of(Mentee sender, Mentor receiver){
        return new Application(sender,receiver);
    }


}