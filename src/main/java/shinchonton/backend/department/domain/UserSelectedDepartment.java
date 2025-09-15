package shinchonton.backend.department.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shinchonton.backend.user.domain.User;

@Entity
@Table(name = "user_selected_answer")
@Getter
@NoArgsConstructor
public class UserSelectedDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User FK
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    // Answer FK
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id")
    private Department department;

    private UserSelectedDepartment(User user, Department department) {
        this.user = user;
        this.department = department;
    }

    public static UserSelectedDepartment userSelected(User user, Department department){
        return new UserSelectedDepartment(user, department);
    }
}
