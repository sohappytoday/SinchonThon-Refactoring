package shinchonton.backend.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;
import shinchonton.backend.user.domain.Mentor;
import shinchonton.backend.user.domain.UserType;
import shinchonton.backend.user.dto.response.MeMentorProfileResponse;
import shinchonton.backend.user.dto.response.MeMenteeProfileResponse;
import shinchonton.backend.user.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserProfileController {
    private final ProfileService profileService;

    //내가 멘토일 때 프로필 보기
    @GetMapping("/me-mentor")
    public ResponseEntity<ApiResponse<MeMentorProfileResponse>> getMeMentorProfile(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID)Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE)String userTypeString) {

        UserType userType = UserType.valueOf(userTypeString.toUpperCase());
        MeMentorProfileResponse profileResponse = profileService.getMeMentorProfile(userId, userType);
        return ResponseEntity.ok(ApiResponse.success("내 프로필 보기 성공",profileResponse));
    }

    //내가 멘티일 때 프로필 보기
    @GetMapping("/me-mentee")
    public ResponseEntity<ApiResponse<MeMenteeProfileResponse>> getMeMenteeProfile(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID)Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE)String userTypeString) {

        UserType userType = UserType.valueOf(userTypeString.toUpperCase());
        MeMenteeProfileResponse profileResponse = profileService.getMeMenteeProfile(userId, userType);
        return ResponseEntity.ok(ApiResponse.success("내 프로필 보기 성공",profileResponse));
    }


    //내가 신청한 멘토 리스트 보기
    @GetMapping("/myMentorList")
    public ResponseEntity<ApiResponse<List<Mentor>>> getMyMentorApplicationsList(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID)Long userId){


    }
    //나에게 신청한 멘티 리스트 보기
}
