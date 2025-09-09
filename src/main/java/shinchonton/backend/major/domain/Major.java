package shinchonton.backend.major.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.users.domain.Category;
import shinchonton.backend.answer.domain.Answer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "major")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;   // 학과명 (예: 컴퓨터공학과, 국어국문학과)

    @Column
    private String content;

    @Enumerated(EnumType.STRING)  // Category enum을 문자열로 저장
    @Column(nullable = false)
    private Category category;   // 계열 (문과/이과/예체능)

    // Many-to-Many 관계 설정
    @ManyToMany
    @JoinTable(
            name = "major_answer3",
            joinColumns = @JoinColumn(name = "major_id"),
            inverseJoinColumns = @JoinColumn(name = "answer3_id")
    )
    private List<Answer> answers3 = new ArrayList<>();
}