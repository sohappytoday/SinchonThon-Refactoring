package shinchonton.backend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.application.repository.ApplicationRepository;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.dto.response.MenteeSelectedMentorsResponse;
import shinchonton.backend.user.dto.response.MentorSelectedMenteesResponse;
import shinchonton.backend.user.repository.MenteeRepository;
import shinchonton.backend.user.repository.MentorRepository;
import shinchonton.backend.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final MenteeRepository menteeRepository;
    private final MentorRepository mentorRepository;

    // 멘토가 선택한 멘티
    public MentorSelectedMenteesResponse getSelectedMentees(Long mentoId) {
        User mento = userRepository.findById(mentoId)
                .orElseThrow(() -> new IllegalArgumentException("멘토 정보를 찾을 수 없습니다."));

        List<Application> applications = applicationRepository.findByReceiver(mento);

        List<MentorSelectedMenteesResponse.MenteeSummary> menteeList = applications.stream()
                .map(app -> MentorSelectedMenteesResponse.MenteeSummary.builder()
                        .nickname(app.getSender().getNickname())
                        .build())
                .collect(Collectors.toList());

        return MentorSelectedMenteesResponse.builder()
                .mentees(menteeList)
                .build();
    }

    // 멘티가 선택한 멘토
    public MenteeSelectedMentorsResponse getSelectedMentors(Long menteeId) {
        User mentee = userRepository.findById(menteeId)
                .orElseThrow(() -> new IllegalArgumentException("멘티 정보를 찾을 수 없습니다."));
        List<Application> applications = applicationRepository.findBySender(mentee);

        List<MenteeSelectedMentorsResponse.MentoSummary> list = applications.stream()
                .map(app -> {
                    User receiver = app.getReceiver();
                    if (receiver instanceof Mentor mento) {
                        return MenteeSelectedMentorsResponse.MentoSummary.builder()
                                .nickname(mento.getNickname())
                                .schoolname(mento.getSchoolName())
                                .department(mento.getDepartment() != null ? mento.getDepartment().getName() : null)
                                .openchaturl(mento.getOpenChatUrl())
                                .description(mento.getDescription())
                                .build();
                    }
                    // (예외적) 멘토 타입이 아닐 경우
                    return MenteeSelectedMentorsResponse.MentoSummary.builder()
                            .nickname(receiver.getNickname())
                            .build();
                })
                .collect(Collectors.toList());

        return MenteeSelectedMentorsResponse.builder().mentors(list).build();
    }

    // 멘티 → 멘토 선택
    @Transactional
    public Long selectMentor(Long menteeId, Long receiverId) {
        Mentee sender = menteeRepository.findByUserId(menteeId)
                .orElseThrow(() -> new IllegalArgumentException("멘티 정보를 찾을 수 없습니다."));
        Mentor receiver = mentorRepository.findByUserId(receiverId)
                .orElseThrow(() -> new IllegalArgumentException("멘토 정보를 찾을 수 없습니다."));

        if (menteeId.equals(receiverId)) {
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
