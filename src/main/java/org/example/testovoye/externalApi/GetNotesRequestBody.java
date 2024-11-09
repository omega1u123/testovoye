package org.example.testovoye.externalApi;

import java.time.LocalDate;

public record GetNotesRequestBody(
        String agency,
        LocalDate dateFrom,
        LocalDate dateTo,
        String clientGuid
) {
}
