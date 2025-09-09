package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.user.domain.Mentor;
import shinchonton.backend.user.dto.response.MentorProfileResponse;
import shinchonton.backend.user.repository.MentorRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorProfileService {

    private final MentorRepository mentorRepository;

    public MentorProfileResponse getProfile(Long userId) {
        Mentor mentor = mentorRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("멘토 정보를 찾을 수 없습니다."));

        return MentorProfileResponse.of(mentor);
    }
}