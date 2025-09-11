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
            throw new AccountAlreadyExist();
        }
        //공용로직 null 체크
        if (request.getUserType() == null
                || request.getName() == null || request.getName().isBlank()
                || request.getAccount() == null || request.getAccount().isBlank()
                || request.getPassword() == null || request.getPassword().isBlank()
        ) {
            throw new RequiredValueEmpty();
        }

        // 멘토 가입
        if (request.getUserType() == UserType.MENTOR) {
            if (request.getNickname() == null || request.getNickname().isBlank()
                    || request.getSchoolName() == null || request.getSchoolName().isBlank()
                    || request.getMajorCategory() == null || request.getMajorCategory().isBlank()
                    || request.getMajor() == null || request.getMajor().isBlank()
                    || request.getOpenChatUrl() == null || request.getOpenChatUrl().isBlank()
                    || request.getDescription() == null || request.getDescription().isBlank()) {
                throw new RequiredValueEmpty();
            }

            Major major = majorRepository.findByName(request.getMajor())
                    .orElseThrow(MajorNotFound::new);

            userRepository.save(Mentor.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .nickname(request.getNickname())
                    .schoolname(request.getSchoolName())
                    .openchaturl(request.getOpenChatUrl())
                    .majorCategory(MajorCategory.from(request.getMajorCategory()))
                    .major(major)
                    .build());


        }

        //Mentee 가입
        else if (request.getUserType() == UserType.MENTEE) {
            if(request.getNickname() == null || request.getNickname().isBlank() || request.getAge() == null){
                throw new RequiredValueEmpty();
            }

            userRepository.save(Mentee.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .nickname(request.getNickname())
                    .age(request.getAge())
                    .build());

        } else {
            throw new RequiredValueEmpty();
        }
    }
}
