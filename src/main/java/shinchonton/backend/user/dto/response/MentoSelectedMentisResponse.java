package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MentoSelectedMentisResponse {
    private List<MentiSummary> mentis;

    @Getter
    @Builder
    public static class MentiSummary {
        private String nickname;
    }
}