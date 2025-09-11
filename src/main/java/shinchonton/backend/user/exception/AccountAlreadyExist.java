package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class AccountAlreadyExist extends BusinessException {

    public AccountAlreadyExist() {
        super(ErrorCode.REDUNDANT_ACCOUNT);
    }
}