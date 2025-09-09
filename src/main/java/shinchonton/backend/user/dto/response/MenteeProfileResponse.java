package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentee;

@Getter
@Builder
public class MenteeProfileResponse {
    private String nickname;

    public static MenteeProfileResponse of(Mentee mentee) {
        return MenteeProfileResponse.builder()
                .nickname(mentee.getNickname())
                .build();
    }
}