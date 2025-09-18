package shinchonton.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.application.repository.ApplicationRepository;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.domain.UserType;
import shinchonton.backend.user.dto.response.*;
import shinchonton.backend.user.exception.DoNotHavePermission;
import shinchonton.backend.user.exception.InvalidUserType;
import shinchonton.backend.user.exception.UserNotFound;
import shinchonton.backend.user.repository.MenteeRepository;
import shinchonton.backend.user.repository.MentorRepository;
import shinchonton.backend.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {
    private final MentorRepository mentorRepository;
    private final MenteeRepository menteeRepository;
    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;

    //내가 멘토일 때 프로필보기
    public MeMentorProfileResponse getMeMentorProfile(Long userId, UserType userType) {

        //멘토일 때 MentorProfileResponse 반환
        if(userType == UserType.MENTOR) {
            Mentor mentor = mentorRepository.findByUserId(userId).orElseThrow(UserNotFound::new);
            MentorCommonProfileResponse mentorCommonProfileResponse = MentorCommonProfileResponse.from(mentor);
            return MeMentorProfileResponse.of(mentorCommonProfileResponse);
        }
        else{
            throw new DoNotHavePermission();
        }
    }

    //내가 멘티일 때 프로필보기
    public MeMenteeProfileResponse getMeMenteeProfile(Long userId, UserType userType) {
        if(!(userType == UserType.MENTEE)) {
            throw new DoNotHavePermission();
        }

        //멘토일 때 MentorProfileResponse 반환
        Mentee mentee = menteeRepository.findByUserId(userId).orElseThrow(UserNotFound::new);
            MenteeCommonProfileResponse menteeCommonProfileResponse = MenteeCommonProfileResponse.of(mentee);
            return MeMenteeProfileResponse.of(menteeCommonProfileResponse);

    }

    //내 멘토리스트 보기
    public List<MyMentorResponse> getMyMentorList(Long userId, UserType userType) {
        if (userType != UserType.MENTEE) {
            throw new DoNotHavePermission();
        }

        User mentee = userRepository.findById(userId)
                .orElseThrow(UserNotFound::new);

        List<Application> applications = applicationRepository.findBySender(mentee);

        return applications.stream()
                .map(Application::getReceiver)
                .filter(receiver -> receiver.getUserType() == UserType.MENTOR)
                .map(MyMentorResponse::from)
                .toList();
    }

    //내 멘티 리스트 보기
    public List<MyMenteeResponse> getMyMenteeList(Long userId, UserType userType){
        if(userType != UserType.MENTOR) {
            throw new DoNotHavePermission();
        }
        User mentor = userRepository.findById(userId).orElseThrow(UserNotFound::new);
        List<Application> applications = applicationRepository.findByReceiver(mentor);

        return applications.stream()
                .map(Application::getSender)
                .filter(sender -> sender.getUserType() == UserType.MENTEE)
                .map(MyMenteeResponse::from)
                .toList();
    }

}
