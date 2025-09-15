package shinchonton.backend.answer.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class InvalidAnswerId extends BusinessException {
    public InvalidAnswerId(){
        super(ErrorCode.INVALID_ANSWER_ID);
    }
}
