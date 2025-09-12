package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentee;

@Getter
@Builder
public class MenteeCommonProfileResponse {
    private String nickname;
    private Long age;

    public static MenteeCommonProfileResponse of(Mentee mentee) {
        return MenteeCommonProfileResponse.builder()
                .nickname(mentee.getNickname())
                .age(mentee.getAge())
                .build();
    }
}