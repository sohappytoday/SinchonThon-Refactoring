package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

//학과가 리스트에 없을 때
public class DepartmentNotFound extends BusinessException {
    public DepartmentNotFound() {
        super(ErrorCode.DEPARTMENT_NOT_FOUND);
    }
}
