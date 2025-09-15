package shinchonton.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.user.domain.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByUserId(Long userId);
    List<Mentor> findAllByDepartmentId(Long departmentId);
}
