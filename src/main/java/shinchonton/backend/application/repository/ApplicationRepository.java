package shinchonton.backend.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.users.domain.Users;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findBySender(Users sender);
    List<Application> findByReceiver(Users receiver);
}