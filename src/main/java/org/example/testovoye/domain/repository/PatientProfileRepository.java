package org.example.testovoye.domain.repository;

import org.example.testovoye.domain.model.PatientProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientProfileRepository extends CrudRepository<PatientProfileEntity, Integer> {

    List<PatientProfileEntity> findTop2ByStatusIdInAndIsImported(List<Integer> statusIds, boolean isImported);

}
