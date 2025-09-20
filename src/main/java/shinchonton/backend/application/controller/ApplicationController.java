package shinchonton.backend.application.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.application.domain.Application;
import shinchonton.backend.application.service.ApplicationService;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    //멘토에게 신청하기
    @PostMapping("/{mentorId}")
    public ResponseEntity<ApiResponse<Void>> submitApplication(@PathVariable Long mentorId,
                                                               @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID)Long userId){
     applicationService.submitApplication(userId, mentorId);
        log.info(">>> mentorId={}, userId={}", mentorId, userId);
     return ResponseEntity.ok(ApiResponse.success("멘토에게 신청을 하였습니다.",null));
    }

}
