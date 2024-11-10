package org.example.testovoye.util;

import org.example.testovoye.domain.model.PatientProfileEntity;
import org.example.testovoye.externalApi.GetClientsResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Utils {

    public Map<String, String> mapPatientsAgencyToHashMap(List<PatientProfileEntity> patients, List<GetClientsResponse> patientsFormOldSystem) {
        Map<String, String> patientsAgency = new HashMap<>();
        if(patientsFormOldSystem.size() == 1){
            if(patientsFormOldSystem.get(0).guid().equals(patients.get(0).getOldClientGuid())){
                patientsAgency.put(patients.get(0).getOldClientGuid(), patientsFormOldSystem.get(0).agency());
            }
            return patientsAgency;
        }
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
