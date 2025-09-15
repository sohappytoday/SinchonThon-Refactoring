package shinchonton.backend.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.department.domain.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional <Department> findByName(String name);
}
