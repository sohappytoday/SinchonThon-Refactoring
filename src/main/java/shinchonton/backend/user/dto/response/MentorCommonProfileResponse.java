package shinchonton.backend.user.dto.response;

import lombok.*;
import shinchonton.backend.user.domain.DepartmentCategory;
import shinchonton.backend.user.domain.Mentor;

@Getter
@Builder
public class MentorCommonProfileResponse {
    /**
     * Mentor의 기본 정보들만 담은 Profile 내용입니다.
     */
    private String nickname;
    private String schoolName;
    private DepartmentCategory departmentCategory;
    private String department;
    private String description;

    public static MentorCommonProfileResponse of(Mentor mentor) {
        return MentorCommonProfileResponse.builder()
                .nickname(mentor.getNickname())
                .schoolName(mentor.getSchoolName())
                .departmentCategory(mentor.getDepartmentCategory())
                .department(mentor.getDepartment().getName())
                .description(mentor.getDescription())
                .build();
    }
}
