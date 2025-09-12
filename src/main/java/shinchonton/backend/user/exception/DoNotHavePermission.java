package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class DoNotHavePermission extends BusinessException {
    public DoNotHavePermission() {

        super(ErrorCode.DO_NOT_HAVE_PERMISSION);
    }
}
