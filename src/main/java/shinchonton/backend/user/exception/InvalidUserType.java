package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class InvalidUserType extends BusinessException {
    public InvalidUserType() {
        super(ErrorCode.INVALID_USER_TYPE);
    }
}
