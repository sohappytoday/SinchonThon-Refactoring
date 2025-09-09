package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.major.domain.Major;
import shinchonton.backend.major.repository.MajorRepository;
import shinchonton.backend.user.domain.*;
import shinchonton.backend.user.dto.request.SignUpRequest;
import shinchonton.backend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final MajorRepository majorRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignUpRequest request) {
        // 계정 중복 체크
        if (userRepository.existsByAccount(request.getAccount())) {
            throw new IllegalArgumentException("이미 사용 중인 계정입니다.");
        }

        // MENTO 가입
        if (request.getUserType() == UserType.MENTO) {
            if (request.getMajor() == null || request.getMajor().isBlank()) {
                throw new IllegalArgumentException("전공은 필수 입력값입니다.");
            }

            Major major = majorRepository.findByName(request.getMajor())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 전공입니다."));

            userRepository.save(Mentor.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .nickname(request.getNickname())
                    .schoolname(request.getSchoolName())
                    .openchaturl(request.getOpenChatUrl())
                    .category(Category.SCIENCE) // TODO: 요청 값에 따라 Category 처리
                    .major(major)
                    .build());

            // MENTI 가입
        } else if (request.getUserType() == UserType.MENTI) {
            userRepository.save(Mentee.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .nickname(request.getNickname())
                    .age(request.getAge() != null ? request.getAge().longValue() : null)
                    .build());

        } else {
            throw new IllegalArgumentException("잘못된 회원 유형입니다.");
        }
    }
}
