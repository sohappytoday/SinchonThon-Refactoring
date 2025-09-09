package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentee;

@Getter
@Builder
public class MentiProfileResponse {
    private String nickname;

    public static MentiProfileResponse of(Mentee mentee) {
        return MentiProfileResponse.builder()
                .nickname(mentee.getNickname())
                .build();
    }
}