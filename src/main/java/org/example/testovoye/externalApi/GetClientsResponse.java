package org.example.testovoye.externalApi;

public record GetClientsResponse(
        String agency,
        String guid,
        String firstName,
        String lastName,
        String status,
        String dob,
        String createdDateTime

) {
}
