package shinchonton.backend.token.dto.response;

public record LoginResponse(
        String accessToken,
        String refreshToken
) {}
