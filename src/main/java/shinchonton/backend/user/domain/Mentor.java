package shinchonton.backend.user.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.major.domain.Major;

@Entity
@DiscriminatorValue("MENTOR") // dtype = 'MENTOR'
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mentor extends User {

    @Column
    private String schoolName;

    @Column
    private String openChatUrl;

    @Enumerated(EnumType.STRING)
    @Column
    private MajorCategory majorCategory;

    @ManyToOne
    @JoinColumn(name = "major_id", nullable = true)
    private Major major;

    @Column
    private String description;

    @Override
    public  UserType getUserType() {
        return UserType.MENTOR;
    }

    @Builder
    public Mentor(String account,
                  String password,
                  String nickname,
                  String schoolname,
                  String openchaturl,
                  MajorCategory majorCategory,
                  Major major,
                  String description) {

        super(null, account, password, nickname);
        this.schoolName = schoolname;
        this.openChatUrl = openchaturl;
        this.majorCategory = majorCategory;
        this.major = major;
        this.description = description;
    }
}
