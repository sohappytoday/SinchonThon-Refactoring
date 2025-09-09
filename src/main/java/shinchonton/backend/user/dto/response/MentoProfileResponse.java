package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentor;

@Getter
@Builder
public class MentoProfileResponse {
    private String nickname;
    private String major;
    private String description;

    public static MentoProfileResponse of(Mentor mentor) {
        return MentoProfileResponse.builder()
                .nickname(mentor.getNickname())
                .major(mentor.getMajor().getName())
                .description(mentor.getDescription())
                .build();
    }
}