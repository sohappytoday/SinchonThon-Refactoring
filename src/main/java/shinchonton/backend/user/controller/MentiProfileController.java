package shinchonton.backend.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;
import shinchonton.backend.user.domain.UserType;
import shinchonton.backend.user.dto.response.MentiProfileResponse;
import shinchonton.backend.user.service.MentiProfileService;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class MentiProfileController {

    private final MentiProfileService mentiProfileService;

    @GetMapping("/menti")
    public ResponseEntity<ApiResponse<MentiProfileResponse>> getMyProfile(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE) String userType
    ) {
        if (!UserType.MENTI.name().equals(userType)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, 400, "멘티만 조회할 수 있습니다.")
            );
        }

        MentiProfileResponse profile = mentiProfileService.getProfile(userId);
        return ResponseEntity.ok(
                new ApiResponse<>(true, 200, "프로필 조회 성공", profile)
        );
    }
}
