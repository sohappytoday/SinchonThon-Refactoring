package shinchonton.backend.major.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "major")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;   // 학과명 (예: 컴퓨터공학과, 국어국문학과)
}