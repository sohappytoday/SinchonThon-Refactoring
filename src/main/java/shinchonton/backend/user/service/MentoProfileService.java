package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.user.domain.Mento;
import shinchonton.backend.user.dto.response.MentoProfileResponse;
import shinchonton.backend.user.repository.MentoRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentoProfileService {

    private final MentoRepository mentoRepository;

    public MentoProfileResponse getProfile(Long userId) {
        Mento mento = mentoRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("멘토 정보를 찾을 수 없습니다."));

        return MentoProfileResponse.of(mento);
    }
}