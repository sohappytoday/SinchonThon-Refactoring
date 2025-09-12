package shinchonton.backend.user.dto.response;

import lombok.*;
import shinchonton.backend.user.domain.MajorCategory;
import shinchonton.backend.user.domain.Mentor;

@Getter
@Builder
public class MentorCommonProfileResponse {
    /**
     * Mentor의 기본 정보들만 담은 Profile 내용입니다.
     */
    private String nickname;
    private String schoolName;
    private MajorCategory majorCategory;
    private String major;
    private String description;

    public static MentorCommonProfileResponse of(Mentor mentor) {
        return MentorCommonProfileResponse.builder()
                .nickname(mentor.getNickname())
                .schoolName(mentor.getSchoolName())
                .majorCategory(mentor.getMajorCategory())
                .major(mentor.getMajor().getName())
                .description(mentor.getDescription())
                .build();
    }
}
