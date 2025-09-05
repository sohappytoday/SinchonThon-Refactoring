package shinchonton.backend.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.application.service.ApplicationService;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;
import shinchonton.backend.users.domain.UserType;
import shinchonton.backend.users.dto.response.MentoSelectedMentisResponse;

@RestController
@RequestMapping("/profile/mento")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/select")
    public ResponseEntity<ApiResponse<MentoSelectedMentisResponse>> getSelectedMentis(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE) String userType
    ) {
        if (!UserType.MENTO.name().equals(userType)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, 400, "멘토만 조회할 수 있습니다.")
            );
        }

        MentoSelectedMentisResponse response = applicationService.getSelectedMentis(userId);
        return ResponseEntity.ok(
                new ApiResponse<>(true, 200, "선택한 멘티 조회 성공", response)
        );
    }
}
