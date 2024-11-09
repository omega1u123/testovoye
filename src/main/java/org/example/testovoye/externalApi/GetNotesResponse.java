package org.example.testovoye.externalApi;

import java.time.LocalDateTime;

public record GetNotesResponse(
        String comments,
        String guid,
        LocalDateTime modifiedDateTime,
        String clientGuid,
        LocalDateTime dateTime,
        String loggedUser,
        LocalDateTime createdDateTime
) {
}