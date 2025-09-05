package shinchonton.backend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.application.repository.ApplicationRepository;
import shinchonton.backend.users.domain.Users;
import shinchonton.backend.users.dto.response.MentoSelectedMentisResponse;
import shinchonton.backend.users.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UsersRepository usersRepository;

    public MentoSelectedMentisResponse getSelectedMentis(Long mentoId) {
        Users mento = usersRepository.findById(mentoId)
                .orElseThrow(() -> new IllegalArgumentException("멘토 정보를 찾을 수 없습니다."));

        List<Application> applications = applicationRepository.findByReceiver(mento);

        List<MentoSelectedMentisResponse.MentiSummary> mentiList = applications.stream()
                .map(app -> MentoSelectedMentisResponse.MentiSummary.builder()
                        .nickname(app.getSender().getNickname())
                        .build())
                .collect(Collectors.toList());

        return MentoSelectedMentisResponse.builder()
                .mentis(mentiList)
                .build();
    }
}
