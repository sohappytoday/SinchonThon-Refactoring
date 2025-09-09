package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentor;

@Getter
@Builder
public class MentorProfileResponse {
    private String nickname;
    private String major;
    private String description;

    public static MentorProfileResponse of(Mentor mentor) {
        return MentorProfileResponse.builder()
                .nickname(mentor.getNickname())
                .major(mentor.getMajor().getName())
                .description(mentor.getDescription())
                .build();
    }
}