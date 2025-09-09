package shinchonton.backend.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MentorSelectedMenteesResponse {
    private List<MenteeSummary> mentees;

    @Getter
    @Builder
    public static class MenteeSummary {
        private String nickname;
    }
}