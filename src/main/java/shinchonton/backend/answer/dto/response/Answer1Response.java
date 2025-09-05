package shinchonton.backend.answer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import shinchonton.backend.answer.domain.Answer;

@Data
@Builder
@AllArgsConstructor
public class Answer1Response {
    private Long answerId;
    private Long prev1Id;
    private String answerContent;

    public static Answer1Response fromEntity(Answer answer) {
        return Answer1Response.builder()
                .answerId(answer.getAnswerId())
                .prev1Id(answer.getPrev1Id())
                .answerContent(answer.getAnswerContent())
                .build();
    }
}
