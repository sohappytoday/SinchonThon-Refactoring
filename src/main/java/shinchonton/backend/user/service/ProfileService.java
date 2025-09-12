package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;
import shinchonton.backend.user.domain.UserType;
import shinchonton.backend.user.dto.response.MeMenteeProfileResponse;
import shinchonton.backend.user.dto.response.MenteeCommonProfileResponse;
import shinchonton.backend.user.dto.response.MentorCommonProfileResponse;
import shinchonton.backend.user.dto.response.MeMentorProfileResponse;
import shinchonton.backend.user.exception.DoNotHavePermission;
import shinchonton.backend.user.exception.InvalidUserType;
import shinchonton.backend.user.exception.UserNotFound;
import shinchonton.backend.user.repository.MenteeRepository;
import shinchonton.backend.user.repository.MentorRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {
    private final MentorRepository mentorRepository;
    private final MenteeRepository menteeRepository;

    //내가 멘토일 때 프로필보기
    public MeMentorProfileResponse getMeMentorProfile(Long userId, UserType userType) {

        //멘토일 때 MentorProfileResponse 반환
        if(userType == UserType.MENTOR) {
            Mentor mentor = mentorRepository.findByUserId(userId).orElseThrow(UserNotFound::new);
            MentorCommonProfileResponse mentorCommonProfileResponse = MentorCommonProfileResponse.of(mentor);
            return MeMentorProfileResponse.of(mentorCommonProfileResponse);
        }
        else{
            throw new DoNotHavePermission();
        }
    }

    //내가 멘티일 때 프로필보기
    public MeMenteeProfileResponse getMeMenteeProfile(Long userId, UserType userType) {

        //멘토일 때 MentorProfileResponse 반환
        if(userType == UserType.MENTEE) {
            Mentee mentee = menteeRepository.findByUserId(userId).orElseThrow(UserNotFound::new);
            MenteeCommonProfileResponse menteeCommonProfileResponse = MenteeCommonProfileResponse.of(mentee);
            return MeMenteeProfileResponse.of(menteeCommonProfileResponse);
        }
        else{
            throw new DoNotHavePermission();
        }
    }
}
