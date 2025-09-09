package shinchonton.backend.application.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.user.domain.Users;

@Entity
@Table(name = "application")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    // 신청 보낸 사람 (멘티)
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Users sender;

    // 신청 받은 사람 (멘토)
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Users receiver;
}