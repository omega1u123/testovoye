package org.example.testovoye.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import org.example.testovoye.util.Utils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImportDataService {

    private final PatientProfileRepository patientProfileRepository;
    private final PatientNoteRepository patientNoteRepository;
    private final OldSystemApi oldSystemApi;
    private final CompanyUserRepository companyUserRepository;
    private final Utils utils;

    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0 15 */2 * * *")
    public void importNotes(){
        try {
            var patients = patientProfileRepository.findTop2ByStatusIdInAndIsImported(Arrays.asList(200, 210, 230), false);
            if(!patients.isEmpty()){
                var patientsFormOldSystem = oldSystemApi.getClients();
                Map<String, String> patientsAgencyMap = utils.mapPatientsAgencyToHashMap(patients, patientsFormOldSystem);
                for(PatientProfileEntity p : patients){
                    var request = new GetNotesRequestBody(
                            patientsAgencyMap.get(p.getOldClientGuid()),
                            LocalDate.of(2019, 9, 18),
                            LocalDate.of(2025, 9, 17),
                            p.getOldClientGuid()
                    );
                    var notesFromOldSystem = oldSystemApi.getNotes(
                            request
                    );
                    for(GetNotesResponse n : notesFromOldSystem){
                        var createdByUser = companyUserRepository.findByLogin(n.loggedUser());
                        if(createdByUser == null){
                            createdByUser = new CompanyUserEntity(n.loggedUser());
                            companyUserRepository.save(createdByUser);
                        }
                        patientNoteRepository.save(new PatientNoteEntity(
                                LocalDateTime.parse(n.createdDateTime(), formater),
                                LocalDateTime.parse(n.modifiedDateTime(), formater),
                                createdByUser,
                                createdByUser,
                                n.comments(),
                                p
                        ));
                        p.setImported(true);
                        patientProfileRepository.save(p);
                        log.info("notes imported for patient with guid : {}",  p.oldClientGuid);
                    }
                }
            }
        }catch (RuntimeException e){
            log.info("import failed with exception: {}", e.getMessage());
        }
    }
}
