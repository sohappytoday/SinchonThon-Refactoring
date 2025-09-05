package shinchonton.backend.users.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // mento/menti를 통합할 테이블
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype") // 구분 컬럼
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public abstract class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String account;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;


}
