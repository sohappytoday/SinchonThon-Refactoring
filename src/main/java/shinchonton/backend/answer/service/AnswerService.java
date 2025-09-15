package shinchonton.backend.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.dto.response.AnswerResponse;
import shinchonton.backend.answer.exception.InvalidAnswerId;
import shinchonton.backend.answer.repository.AnswerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    //첫번째 질문 보여주기
    public List<AnswerResponse> showFirstAnswerList() {

        List<Answer> firstAnswerList = answerRepository.findAllByPrevAnswerIsNull();
        return firstAnswerList.stream()
                .map(AnswerResponse::from)
                .toList();
    }

    //다음 답변 리스트 보여주기
    public List<AnswerResponse> showNextAnswerList(Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(InvalidAnswerId::new);

        List<Answer> nextAnswers = answer.getNextAnswers();

        return nextAnswers.stream()
                .map(AnswerResponse::from)
                .toList();
    }

}
