package shinchonton.backend.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.department.domain.UserSelectedDepartment;

public interface UserSelectedDepartmentRepository extends JpaRepository<UserSelectedDepartment, Long> {


}
