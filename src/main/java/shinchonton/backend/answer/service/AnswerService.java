package shinchonton.backend.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.domain.UserSelectedAnswer;
import shinchonton.backend.answer.dto.response.AnswerResponse;
import shinchonton.backend.answer.exception.InvalidAnswerId;
import shinchonton.backend.answer.repository.AnswerRepository;
import shinchonton.backend.answer.repository.UserSelectedAnswerRepository;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.exception.UserNotFound;
import shinchonton.backend.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final UserSelectedAnswerRepository userSelectedAnswerRepository;

    //다음 답변 리스트 보여주기
    public List<AnswerResponse> showNextAnswerList(Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(InvalidAnswerId::new);

        List<Answer> nextAnswers = answer.getNextAnswers();

        return nextAnswers.stream()
                .map(AnswerResponse::from)
                .toList();
    }

    //마지막 답변 리스트 보여주기(저장 포함)
    @Transactional
    public List<AnswerResponse> showAnswerList(Long userId, Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(InvalidAnswerId::new);
        User user = userRepository.findById(userId).orElseThrow(UserNotFound::new);

        List<Answer> nextAnswers = answer.getNextAnswers();

        //UserSelectedAnswer에 저장
        UserSelectedAnswer userSelectedAnswer = UserSelectedAnswer.userSelected(user, answer);
        userSelectedAnswerRepository.save(userSelectedAnswer);

        return nextAnswers.stream()
                .map(AnswerResponse::from)
                .toList();
    }
}
