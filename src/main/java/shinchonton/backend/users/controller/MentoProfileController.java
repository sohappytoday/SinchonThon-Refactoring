package shinchonton.backend.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;
import shinchonton.backend.users.domain.UserType;
import shinchonton.backend.users.dto.response.MentoProfileResponse;
import shinchonton.backend.users.service.MentoProfileService;

@RestController
@RequestMapping("/profile") // 공통 prefix
@RequiredArgsConstructor
public class MentoProfileController {

    private final MentoProfileService mentoProfileService;

    @GetMapping("/mento")
    public ResponseEntity<ApiResponse<MentoProfileResponse>> getMyProfile(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE) String userType
    ) {
        if (!UserType.MENTO.name().equals(userType)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, 400, "멘토만 조회할 수 있습니다.")
            );
        }

        MentoProfileResponse profile = mentoProfileService.getProfile(userId);
        return ResponseEntity.ok(
                new ApiResponse<>(true, 200, "프로필 조회 성공", profile)
        );
    }
}
