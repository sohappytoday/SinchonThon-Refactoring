package shinchonton.backend.users.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.users.domain.Menti;

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