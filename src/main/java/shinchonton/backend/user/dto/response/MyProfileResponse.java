package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.Mentee;
import shinchonton.backend.user.domain.Mentor;

@Getter
@Builder
public class MyProfileResponse implements ProfileResponse {
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