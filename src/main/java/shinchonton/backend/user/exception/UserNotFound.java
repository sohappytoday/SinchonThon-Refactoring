package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class UserNotFound extends BusinessException {
    public UserNotFound() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}

