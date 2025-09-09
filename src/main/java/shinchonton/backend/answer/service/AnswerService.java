package shinchonton.backend.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.domain.UserAnswer;
import shinchonton.backend.answer.dto.response.AnswerResponse;
import shinchonton.backend.answer.repository.AnswerRepository;
import shinchonton.backend.answer.repository.UserAnswerRepository;
import shinchonton.backend.major.dto.MajorResponse;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final UserAnswerRepository userAnswerRepository;
    private final UserRepository userRepository;

    public List<AnswerResponse> getFirstAnswers() {
        return answerRepository.findAllById(List.of(1L, 2L, 3L)) // id = 1,2,3만 조회
                .stream()
                .map(a -> new AnswerResponse(a.getAnswerId(), a.getAnswerContent()))
                .toList();
    }

    @Transactional
    public List<AnswerResponse> saveFirstAnswerAndGetNext(Long userId, Long answerId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));

        UserAnswer userAnswer = userAnswerRepository.findByUser(user)
                .orElse(UserAnswer.builder().user(user).build());

        userAnswer.setAnswer1(
                answerRepository.findById(answerId)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 답변"))
        );

        userAnswerRepository.save(userAnswer);

        return answerRepository.findByPrev1IdAndPrev2IdIsNull(answerId)
                .stream()
                .map(AnswerResponse::fromEntity)
                .toList();
    }

    @Transactional
    public List<AnswerResponse> saveSecondAnswerAndGetNext(Long userId, Long answerId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));

        // userAnswer 찾거나 새로 생성
        UserAnswer userAnswer = userAnswerRepository.findByUser(user)
                .orElse(UserAnswer.builder().user(user).build());

        // answer2 저장
        Answer selectedAnswer = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 답변"));
        userAnswer.setAnswer2(selectedAnswer);

        userAnswerRepository.save(userAnswer);

        // 무조건 id = 18, 19를 반환
        return answerRepository.findAllById(List.of(18L, 19L))
                .stream()
                .map(a -> new AnswerResponse(a.getAnswerId(), a.getAnswerContent()))
                .toList();
    }

    @Transactional
    public List<AnswerResponse> saveThirdAnswerAndGetNext(Long userId, Long answerId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));

        UserAnswer userAnswer = userAnswerRepository.findByUser(user)
                .orElseThrow(() -> new IllegalArgumentException("2번 답변 먼저 저장해야 합니다."));

        userAnswer.setAnswer3(
                answerRepository.findById(answerId)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 답변"))
        );

        userAnswerRepository.save(userAnswer);

        return answerRepository.findByPrev2IdAndPrev3Id(userAnswer.getAnswer2().getAnswerId(), answerId)
                .stream()
                .map(AnswerResponse::fromEntity)
                .toList();
    }

    @Transactional
    public List<MajorResponse> saveFourthAnswerAndGetMajors(Long userId, Long answerId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));

        // 유저의 답변 불러오기 (없으면 새로 생성)
        UserAnswer userAnswer = userAnswerRepository.findByUser(user)
                .orElse(UserAnswer.builder().user(user).build());

        // 4번째 답변 저장
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 답변"));
        userAnswer.setAnswer4(answer);

        userAnswerRepository.save(userAnswer);

        // Answer 기준으로 Major 리스트 조회
        return answer.getMajors().stream()
                .map(m -> new MajorResponse(m.getName(), m.getContent()))
                .toList();
    }

}
