package shinchonton.backend.answer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerResponse {
    private Long answerId;
    private String answerContent;

    public static AnswerResponse fromEntity(shinchonton.backend.answer.domain.Answer answer) {
        return new AnswerResponse(answer.getAnswerId(), answer.getAnswerContent());
    }
}