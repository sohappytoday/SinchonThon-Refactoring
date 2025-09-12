package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;
import shinchonton.backend.user.domain.UserType;
import shinchonton.backend.user.dto.response.MenteeCommonProfileResponse;
import shinchonton.backend.user.dto.response.MentorCommonProfileResponse;
import shinchonton.backend.user.dto.response.MyProfileResponse;
import shinchonton.backend.user.dto.response.ProfileResponse;
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

    public ProfileResponse getMyProfile(Long userId, UserType userType) {

        //멘토일 때 MentorProfileResponse 반환
        if(userType == UserType.MENTOR) {
            Mentor mentor = mentorRepository.findByUserId(userId).orElseThrow(UserNotFound::new);
            MentorCommonProfileResponse mentorCommonProfileResponse = MentorCommonProfileResponse.of(mentor);
            return MyProfileResponse.of(mentorCommonProfileResponse);

        }
        //멘티일 때 MenteeProfileResponse 반환
        else if(userType == UserType.MENTEE){
            Mentee mentee = menteeRepository.findByUserId(userId).orElseThrow(UserNotFound::new);
            MenteeCommonProfileResponse menteeCommonProfileResponse = MenteeCommonProfileResponse.of(mentee);
            return MyProfileResponse.of(menteeCommonProfileResponse);
        }
        else{
            throw new InvalidUserType();
        }
    }
}
