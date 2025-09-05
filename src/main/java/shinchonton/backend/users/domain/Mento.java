package shinchonton.backend.users.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.major.domain.Major;

@Entity
@DiscriminatorValue("MENTO") // dtype = 'MENTO'
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mento extends Users {

    @Column
    private String schoolname;

    @Column
    private String openchaturl;

    @Enumerated(EnumType.STRING)
    @Column
    private Category category;

    @OneToOne
    @JoinColumn(name = "major_id", nullable = true) // FK
    private Major major;

    @Override
    public  UserType getUserType() {
        return UserType.MENTO;
    }

    @Builder
    public Mento(String account,
                 String password,
                 String nickname,
                 String schoolname,
                 String openchaturl,
                 Category category,
                 Major major) {

        super(null, account, password, nickname);

        // === 필수 값 검증 ===
        if (schoolname == null || schoolname.isBlank()) {
            throw new IllegalArgumentException("schoolname is required");
        }
        if (openchaturl == null || openchaturl.isBlank()) {
            throw new IllegalArgumentException("openchaturl is required");
        }
        if (category == null) {
            throw new IllegalArgumentException("category is required");
        }
        if (major == null) {
            throw new IllegalArgumentException("major is required");
        }

        this.schoolname = schoolname;
        this.openchaturl = openchaturl;
        this.category = category;
        this.major = major;
    }
}
