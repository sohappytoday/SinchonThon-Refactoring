package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MenteeSelectedMentorsResponse {
    private List<MentoSummary> mentors;

    @Getter
    @Builder
    public static class MentoSummary {
        private String nickname;
        private String schoolname;
        private String major;
        private String openchaturl;
        private String description;
    }
}
