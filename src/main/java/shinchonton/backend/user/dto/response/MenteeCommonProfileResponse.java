package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentee;

@Getter
@Builder
public class MenteeCommonProfileResponse {
    /**
     * Mentee의 기본 정보만 담겨 있는 ProfileResponse 입니다.
     */
    private Long menteeId;
    private String nickname;
    private Long age;

    public static MenteeCommonProfileResponse of(Mentee mentee) {
        return MenteeCommonProfileResponse.builder()
                .menteeId(mentee.getUserId())
                .nickname(mentee.getNickname())
                .age(mentee.getAge())
                .build();
    }
}