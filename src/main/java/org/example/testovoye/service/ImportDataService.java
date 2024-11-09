package org.example.testovoye.service;

import lombok.RequiredArgsConstructor;
import org.example.testovoye.domain.model.CompanyUserEntity;
import org.example.testovoye.domain.model.PatientNoteEntity;
import org.example.testovoye.domain.model.PatientProfileEntity;
import org.example.testovoye.domain.repository.CompanyUserRepository;
import org.example.testovoye.domain.repository.PatientNoteRepository;
import org.example.testovoye.domain.repository.PatientProfileRepository;
import org.example.testovoye.externalApi.GetClientsResponse;
import org.example.testovoye.externalApi.GetNotesRequestBody;
import org.example.testovoye.externalApi.GetNotesResponse;
import org.example.testovoye.externalApi.OldSystemApi;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ImportDataService {

    private final PatientProfileRepository patientProfileRepository;
    private final PatientNoteRepository patientNoteRepository;
    private final OldSystemApi oldSystemApi;
    private final CompanyUserRepository companyUserRepository;

    public void importNotes(){
        var patients = patientProfileRepository.findTop2ByPatientsByStatusIds(Arrays.asList(200, 210, 230));
        if(!patients.isEmpty()){
            Map<String, String> patientsAgency = mapPatientsAgencyToHashMap(patients);
            for(PatientProfileEntity p : patients){
                var notesFromOldSystem = oldSystemApi.getNotes(
                        new GetNotesRequestBody(
                                patientsAgency.get(p.getOldClientGuid()),
                                LocalDate.of(2019, 9, 18),
                                LocalDate.of(2021, 9, 17),
                                p.getOldClientGuid()
                        )
                );

               for(GetNotesResponse n : notesFromOldSystem){
                   var createdByUser = companyUserRepository.findByLogin(n.loggedUser());
                   if(createdByUser == null){
                       createdByUser = new CompanyUserEntity(n.loggedUser());
                       companyUserRepository.save(createdByUser);
                   }
                   patientNoteRepository.save(new PatientNoteEntity(
                           n.createdDateTime(),
                           n.modifiedDateTime(),
                           createdByUser,
                           createdByUser,
                           n.comments()
                   ));
               }
            }
        }
    }

    private Map<String, String> mapPatientsAgencyToHashMap(List<PatientProfileEntity> patients) {
        var patientsFormOldSystem = oldSystemApi.getClients();
        Map<String, String> patientsAgency = new HashMap<>();

        for(GetClientsResponse p : patientsFormOldSystem){
            if(p.guid().equals(patients.get(0).getOldClientGuid())){
                patientsAgency.put(patients.get(0).getOldClientGuid(), p.agency());
            }
            if(p.guid().equals(patients.get(1).getOldClientGuid())){
                patientsAgency.put(patients.get(1).getOldClientGuid(), p.agency());
            }
        }
        return patientsAgency;
    }


}
