package shinchonton.backend.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findBySender(User sender);
    List<Application> findByReceiver(User receiver);

    boolean existsBySenderAndReceiver(User sender, User receiver);
    Optional<Application> findBySenderAndReceiver(User sender, User receiver);
}