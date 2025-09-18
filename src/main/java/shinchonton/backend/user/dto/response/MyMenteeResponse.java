package shinchonton.backend.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentee;

@Getter
@AllArgsConstructor
@Builder
public class MyMenteeResponse {
    private Long menteeId;
    private String nickname;
    private Long age;

    public static MyMenteeResponse from(Mentee mentee) {
        return MyMenteeResponse.builder()
                .menteeId(mentee.getUserId())
                .nickname(mentee.getNickname())
                .age(mentee.getAge())
                .build();
    }
}
