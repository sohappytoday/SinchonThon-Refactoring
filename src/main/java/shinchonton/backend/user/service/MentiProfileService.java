package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.user.dto.response.MentiProfileResponse;
import shinchonton.backend.user.repository.MenteeRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentiProfileService {

    private final MenteeRepository menteeRepository;

    public MentiProfileResponse getProfile(Long userId) {
        return menteeRepository.findByUserId(userId)
                .map(MentiProfileResponse::of)
                .orElseThrow(() -> new IllegalArgumentException("멘티 정보를 찾을 수 없습니다."));
    }
}
