package shinchonton.backend.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentor;

@Getter
@AllArgsConstructor
@Builder
public class MyMentorResponse {
    private Long mentorId;
    private String mentorNickname;
    private String schoolName;
    private String openChatUrl;
    private String department;
    private String description;

    public static MyMentorResponse from(Mentor mentor) {
        return MyMentorResponse.builder()
                .mentorId(mentor.getUserId())
                .mentorNickname(mentor.getNickname())
                .schoolName(mentor.getSchoolName())
                .openChatUrl(mentor.getOpenChatUrl())
                .department(mentor.getDepartment().toString())
                .description(mentor.getDescription())
                .build();
    }
}
