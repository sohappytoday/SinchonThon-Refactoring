package shinchonton.backend.token.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class InvalidPasswordException extends BusinessException {

    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
