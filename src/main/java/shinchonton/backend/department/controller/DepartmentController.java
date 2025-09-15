package shinchonton.backend.department.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.department.service.DepartmentService;
import shinchonton.backend.user.dto.response.MentorCommonProfileResponse;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/{departmentId}/mentors")
    public ResponseEntity<ApiResponse<List<MentorCommonProfileResponse>>> mentorsByDepartmentId(@PathVariable Long departmentId) {
        List<MentorCommonProfileResponse> mentorList = departmentService.showMentorListByDepartmentId(departmentId);

        return ResponseEntity.ok(ApiResponse.success("학과와 관련된 멘토 리스트 불러오기에 성공하였습니다.", mentorList));
    }

}
