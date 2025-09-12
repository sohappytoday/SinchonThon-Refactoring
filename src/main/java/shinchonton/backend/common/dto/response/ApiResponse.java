package shinchonton.backend.common.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;

    public ApiResponse(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ApiResponse(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, 200, message, data);
    }

    public static <T> ApiResponse<T> failure(String message, T data) {
        return new ApiResponse<>(false, 500, message, data);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, 200, message, null);
    }
}