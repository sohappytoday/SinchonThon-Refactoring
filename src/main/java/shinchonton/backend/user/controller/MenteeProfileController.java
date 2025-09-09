package shinchonton.backend.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;
import shinchonton.backend.user.domain.UserType;
import shinchonton.backend.user.dto.response.MenteeProfileResponse;
import shinchonton.backend.user.service.MenteeProfileService;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class MenteeProfileController {

    private final MenteeProfileService menteeProfileService;

    @GetMapping("/mentee")
    public ResponseEntity<ApiResponse<MenteeProfileResponse>> getMyProfile(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE) String userType
    ) {
        if (!UserType.MENTEE.name().equals(userType)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, 400, "멘티만 조회할 수 있습니다.")
            );
        }

        MenteeProfileResponse profile = menteeProfileService.getProfile(userId);
        return ResponseEntity.ok(
                new ApiResponse<>(true, 200, "프로필 조회 성공", profile)
        );
    }
}
