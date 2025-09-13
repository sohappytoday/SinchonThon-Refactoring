package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class InvalidDepartmentCategory extends BusinessException {
    public InvalidDepartmentCategory() {
        super(ErrorCode.INVALID_DEPARTMENT_CATEGORY);
    }
}
