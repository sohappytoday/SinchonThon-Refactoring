package shinchonton.backend.application.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.application.dto.request.SelectMentorRequest;
import shinchonton.backend.application.service.ApplicationService;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;
import shinchonton.backend.user.domain.UserType;
import shinchonton.backend.user.dto.response.MentiSelectedMentosResponse;
import shinchonton.backend.user.dto.response.MentoSelectedMentisResponse;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    // 나를 선택한 멘티 조회
    @GetMapping("/mento/select")
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

    // 내가 선택한 멘토 조회
    @GetMapping("/menti/select")
    public ResponseEntity<ApiResponse<MentiSelectedMentosResponse>> getSelectedMentos(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE) String userType
    ) {
        if (!UserType.MENTI.name().equals(userType)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, 400, "멘티만 조회할 수 있습니다.")
            );
        }

        MentiSelectedMentosResponse response = applicationService.getSelectedMentos(userId);
        return ResponseEntity.ok(
                new ApiResponse<>(true, 200, "선택한 멘토 조회 성공", response)
        );
    }

    // 멘티가 멘토 선택
    @PostMapping("/menti/select")
    public ResponseEntity<ApiResponse<Long>> selectMentor(
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID) Long userId,
            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_TYPE) String userType,
            @Valid @RequestBody SelectMentorRequest request
    ) {
        if (!UserType.MENTI.name().equals(userType)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, 400, "멘티만 신청할 수 있습니다.")
            );
        }
        Long applicationId = applicationService.selectMentor(userId, request.receiverId());
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "멘토 신청 성공", applicationId));
    }
}
