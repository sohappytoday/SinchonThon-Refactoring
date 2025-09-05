package shinchonton.backend.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.repository.AnswerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnswerService {

    private final AnswerRepository answerRepository;

    public List<Answer> getSecondAnswers(Long prev1Id) {
        return answerRepository.findByPrev1IdAndPrev2IdIsNull(prev1Id);
    }
}
