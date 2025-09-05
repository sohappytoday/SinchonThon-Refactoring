package shinchonton.backend.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.major.domain.Major;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major, Long> {
    Optional<Major> findByName(String name);
}
