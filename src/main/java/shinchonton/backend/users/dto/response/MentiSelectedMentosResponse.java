package shinchonton.backend.users.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MentiSelectedMentosResponse {
    private List<MentoSummary> mentos;

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
