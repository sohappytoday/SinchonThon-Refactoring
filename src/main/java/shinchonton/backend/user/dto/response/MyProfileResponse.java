package shinchonton.backend.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyProfileResponse implements ProfileResponse {
    /**
     * 내 프로필 보기 Response 입니다.
     */
    private MentorCommonProfileResponse mentorProfile;
    private MenteeCommonProfileResponse menteeProfile;

    public static MyProfileResponse of(MentorCommonProfileResponse mentorCommonProfileResponse) {
        return MyProfileResponse.builder()
                .mentorProfile(mentorCommonProfileResponse)
                .menteeProfile(null)
                .build();
    }

    public static MyProfileResponse of(MenteeCommonProfileResponse menteeCommonProfileResponse) {
        return MyProfileResponse.builder()
                .menteeProfile(menteeCommonProfileResponse)
                .mentorProfile(null)
                .build();
    }
}