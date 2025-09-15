package shinchonton.backend.answer.dto.response;

import lombok.AllArgsConstructor;
import lombok.*;
import shinchonton.backend.answer.domain.Answer;

@Getter
@AllArgsConstructor
@Builder
public class AnswerResponse {
    private Long answerId;
    private String answerContent;

    public static AnswerResponse from(Answer answer) {
        return AnswerResponse.builder()
                .answerId(answer.getId())
                .answerContent(answer.getContent())
                .build();
    }
}