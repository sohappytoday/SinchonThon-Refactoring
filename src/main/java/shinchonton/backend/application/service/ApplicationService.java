package shinchonton.backend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.application.repository.ApplicationRepository;
import shinchonton.backend.user.domain.Menti;
import shinchonton.backend.user.domain.Mento;
import shinchonton.backend.user.domain.Users;
import shinchonton.backend.user.dto.response.MentiSelectedMentosResponse;
import shinchonton.backend.user.dto.response.MentoSelectedMentisResponse;
import shinchonton.backend.user.repository.MentiRepository;
import shinchonton.backend.user.repository.MentoRepository;
import shinchonton.backend.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final MentiRepository mentiRepository;
    private final MentoRepository mentoRepository;

    // 멘토가 선택한 멘티
    public MentoSelectedMentisResponse getSelectedMentis(Long mentoId) {
        Users mento = userRepository.findById(mentoId)
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

    // 멘티가 선택한 멘토
    public MentiSelectedMentosResponse getSelectedMentos(Long mentiId) {
        Users menti = userRepository.findById(mentiId)
                .orElseThrow(() -> new IllegalArgumentException("멘티 정보를 찾을 수 없습니다."));
        List<Application> applications = applicationRepository.findBySender(menti);

        List<MentiSelectedMentosResponse.MentoSummary> list = applications.stream()
                .map(app -> {
                    Users receiver = app.getReceiver();
                    if (receiver instanceof Mento mento) {
                        return MentiSelectedMentosResponse.MentoSummary.builder()
                                .nickname(mento.getNickname())
                                .schoolname(mento.getSchoolname())
                                .major(mento.getMajor() != null ? mento.getMajor().getName() : null)
                                .openchaturl(mento.getOpenchaturl())
                                .description(mento.getDescription())
                                .build();
                    }
                    // (예외적) 멘토 타입이 아닐 경우
                    return MentiSelectedMentosResponse.MentoSummary.builder()
                            .nickname(receiver.getNickname())
                            .build();
                })
                .collect(Collectors.toList());

        return MentiSelectedMentosResponse.builder().mentos(list).build();
    }

    // 멘티 → 멘토 선택
    @Transactional
    public Long selectMentor(Long mentiId, Long receiverId) {
        Menti sender = mentiRepository.findByUserId(mentiId)
                .orElseThrow(() -> new IllegalArgumentException("멘티 정보를 찾을 수 없습니다."));
        Mento receiver = mentoRepository.findByUserId(receiverId)
                .orElseThrow(() -> new IllegalArgumentException("멘토 정보를 찾을 수 없습니다."));

        if (mentiId.equals(receiverId)) {
            throw new IllegalArgumentException("자기 자신에게는 신청할 수 없습니다.");
        }

        boolean exists = applicationRepository.findBySender(sender).stream()
                .anyMatch(app -> app.getReceiver().getUserId().equals(receiverId));
        if (exists) {
            throw new IllegalArgumentException("이미 신청한 멘토입니다.");
        }

        Application saved = applicationRepository.save(
                Application.builder()
                        .sender(sender)
                        .receiver(receiver)
                        .build()
        );
        return saved.getApplicationId();
    }
}
