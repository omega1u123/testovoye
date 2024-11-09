package org.example.testovoye.domain.repository;

import org.example.testovoye.domain.model.PatientNoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientNoteRepository extends CrudRepository<PatientNoteEntity, Integer> {
}
