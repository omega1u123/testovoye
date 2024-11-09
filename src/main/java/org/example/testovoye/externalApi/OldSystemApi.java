package org.example.testovoye.externalApi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OldSystemApi {

    private final RestTemplate restTemplate;

    public List<GetClientsResponse> getClients(){
        ResponseEntity<GetClientsResponse[]> response = restTemplate.postForEntity(
                "http://localhost:8081/clients", null, GetClientsResponse[].class);
        return Arrays.asList(response.getBody());
    }

    public List<GetNotesResponse> getNotes(GetNotesRequestBody requestBody){
        ResponseEntity<GetNotesResponse[]> response = restTemplate.postForEntity(
                "http://localhost:8081/notes", requestBody, GetNotesResponse[].class
        );
        return Arrays.asList(response.getBody());
    }

}
