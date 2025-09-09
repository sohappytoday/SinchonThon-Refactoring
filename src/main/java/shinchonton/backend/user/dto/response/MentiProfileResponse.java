package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Menti;

@Getter
@Builder
public class MentiProfileResponse {
    private String nickname;

    public static MentiProfileResponse of(Menti menti) {
        return MentiProfileResponse.builder()
                .nickname(menti.getNickname())
                .build();
    }
}