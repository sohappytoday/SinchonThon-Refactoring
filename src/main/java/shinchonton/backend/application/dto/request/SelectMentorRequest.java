package shinchonton.backend.application.dto.request;

import jakarta.validation.constraints.NotNull;

public record SelectMentorRequest(
        @NotNull Long receiverId
) {}
