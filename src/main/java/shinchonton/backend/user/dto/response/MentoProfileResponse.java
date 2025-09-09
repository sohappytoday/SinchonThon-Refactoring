package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mento;

@Getter
@Builder
public class MentoProfileResponse {
    private String nickname;
    private String major;
    private String description;

    public static MentoProfileResponse of(Mento mento) {
        return MentoProfileResponse.builder()
                .nickname(mento.getNickname())
                .major(mento.getMajor().getName())
                .description(mento.getDescription())
                .build();
    }
}