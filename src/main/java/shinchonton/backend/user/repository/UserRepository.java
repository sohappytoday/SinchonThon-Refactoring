package shinchonton.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByAccount(String account);
    boolean existsByAccount(String account);
}