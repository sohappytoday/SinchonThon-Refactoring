package shinchonton.backend.favorite.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shinchonton.backend.user.domain.User;

@Entity
@Table(name = "favorite")
@Getter
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private Favorite(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public static Favorite create(User sender, User receiver){
        return new Favorite(sender, receiver);
    }

}