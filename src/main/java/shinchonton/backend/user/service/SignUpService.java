package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.major.domain.Major;
import shinchonton.backend.major.repository.MajorRepository;
import shinchonton.backend.user.domain.*;
import shinchonton.backend.user.dto.request.SignUpRequest;
import shinchonton.backend.user.exception.AccountAlreadyExist;
import shinchonton.backend.user.exception.MajorNotFound;
import shinchonton.backend.user.exception.RequiredValueEmpty;
import shinchonton.backend.user.exception.UserNotFound;
import shinchonton.backend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class SignUpService {

    private final UserRepository userRepository;
    private final MajorRepository majorRepository;
    private final PasswordEncoder passwordEncoder;

    //userId로 User 정보 조회
    public User findById(Long userId){
        return userRepository.findById(userId).orElseThrow(UserNotFound::new);
    }

    //회원가입
    public void signup(SignUpRequest request) {
        // 계정 중복 체크
        if (userRepository.existsByAccount(request.getAccount())) {
            throw new AccountAlreadyExist();
        }

        // 공통 SignUp 부분 null 체크
        if (request.getUserType() == null
                || nullOrBlank(request.getName())
                || nullOrBlank(request.getAccount())
                || nullOrBlank(request.getPassword())) {
            throw new RequiredValueEmpty();
        }

        // 멘토 가입
        if (request.getUserType() == UserType.MENTOR) {
            if (nullOrBlank(request.getMentor().getNickname())
                    || nullOrBlank(request.getMentor().getSchoolName())
                    || nullOrBlank(String.valueOf(request.getMentor().getMajorCategory()))
                    || nullOrBlank(request.getMentor().getMajor())
                    || nullOrBlank(request.getMentor().getOpenChatUrl())
                    || nullOrBlank(request.getMentor().getDescription())) {
                throw new RequiredValueEmpty();
            }

            //학과 있는지 체크
            Major major = majorRepository.findByName(request.getMentor().getMajor())
                    .orElseThrow(MajorNotFound::new);

            userRepository.save(Mentor.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .nickname(request.getMentor().getNickname())
                    .schoolname(request.getMentor().getSchoolName())
                    .openchaturl(request.getMentor().getOpenChatUrl())
                    .majorCategory(request.getMentor().getMajorCategory())
                    .description(request.getMentor().getDescription())
                    .major(major)
                    .build());
        }

        // 멘티 가입
        else if (request.getUserType() == UserType.MENTEE) {
            if (nullOrBlank(request.getMentee().getNickname()) || request.getMentee().getAge() == null) {
                throw new RequiredValueEmpty();
            }

            userRepository.save(Mentee.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .nickname(request.getMentee().getNickname())
                    .age(request.getMentee().getAge())
                    .build());
        }

        // userType 잘못 들어온 경우
        else {
            throw new RequiredValueEmpty();
        }
    }

    // 불편해서 만든 값이 null이거나, 빈칸으로 채워져있을 때를 거르는 private method
    private boolean nullOrBlank(String value) {
        return value == null || value.isBlank();
    }

}
