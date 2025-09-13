package shinchonton.backend.user.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.department.domain.Department;

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
    private DepartmentCategory departmentCategory;

    @ManyToOne
    @JoinColumn(name = "major_id", nullable = true)
    private Department department;

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
                  DepartmentCategory departmentCategory,
                  Department department,
                  String description) {

        super(null, account, password, nickname);
        this.schoolName = schoolname;
        this.openChatUrl = openchaturl;
        this.departmentCategory = departmentCategory;
        this.department = department;
        this.description = description;
    }
}
