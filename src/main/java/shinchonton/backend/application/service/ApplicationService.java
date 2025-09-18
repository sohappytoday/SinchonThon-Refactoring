package shinchonton.backend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.application.repository.ApplicationRepository;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.exception.UserNotFound;
import shinchonton.backend.user.repository.MenteeRepository;
import shinchonton.backend.user.repository.MentorRepository;
import shinchonton.backend.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final MenteeRepository menteeRepository;
    private final MentorRepository mentorRepository;

    public void submitApplication(Long userId, Long mentorId){
        Mentee mentee = menteeRepository.findById(userId).orElseThrow(UserNotFound::new);
        Mentor mentor = mentorRepository.findById(mentorId).orElseThrow(UserNotFound::new);

        Application application = Application.of(mentee,mentor);
        applicationRepository.save(application);
    }

}
