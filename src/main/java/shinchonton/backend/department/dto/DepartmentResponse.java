package shinchonton.backend.department.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import shinchonton.backend.department.domain.Department;

@Getter
@AllArgsConstructor
@Builder
public class DepartmentResponse {
    private String name;
    private String content;

    public static DepartmentResponse from(Department department) {
       return DepartmentResponse.builder()
               .name(department.getName())
               .content(department.getContent())
               .build();
    }
}