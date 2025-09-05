package shinchonton.backend.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.users.domain.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByAccount(String account);
    boolean existsByAccount(String account);
}