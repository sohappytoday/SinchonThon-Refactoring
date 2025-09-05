package shinchonton.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "mento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String account;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String schoolname;

    @Column
    private String openchaturl;

    @Column
    private String category;
}