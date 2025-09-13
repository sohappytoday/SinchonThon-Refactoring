package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MeMenteeProfileResponse {
    /**
     * 내 프로필 보기 Response 입니다.
     */
    private MenteeCommonProfileResponse menteeCommonProfileResponse;

    public static MeMenteeProfileResponse of(MenteeCommonProfileResponse menteeCommonProfileResponse) {
        return MeMenteeProfileResponse.builder()
                .menteeCommonProfileResponse(menteeCommonProfileResponse)
                .build();
    }
}