package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MeMentorProfileResponse {
    /**
     * 내 프로필 보기 Response 입니다.
     */
    private MentorCommonProfileResponse mentorCommonProfileResponse;

    public static MeMentorProfileResponse of(MentorCommonProfileResponse mentorCommonProfileResponse) {
        return MeMentorProfileResponse.builder()
                .mentorCommonProfileResponse(mentorCommonProfileResponse)
                .build();
    }


}