package shinchonton.backend.department.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.user.domain.DepartmentCategory;
import shinchonton.backend.answer.domain.Answer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;   // 학과명

    @Column(nullable = false)
    private String content; // 학과 소개글

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DepartmentCategory departmentCategory;   // 계열 (문과/이과/예체능)

}