package shinchonton.backend.major.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.users.domain.Category;

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

    @Enumerated(EnumType.STRING)  // Category enum을 문자열로 저장
    @Column(nullable = false)
    private Category category;   // 계열 (문과/이과/예체능)
}