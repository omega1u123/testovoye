package org.example.testovoye.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "patient_note")
public class PatientNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "created_date_time")
    public LocalDateTime createdDateTime;

    @Column(name = "last_modified_date_time")
    public LocalDateTime lastModifiedDateTime;

    @Column(name = "created_by_user_id")
    @ManyToOne
    public CompanyUserEntity createdByUserId;

    @Column(name = "last_modified_by_user_id")
    @ManyToOne
    public CompanyUserEntity lastModifiedByUserId;

    @Column(name = "note")
    public String note;

    public PatientNoteEntity(LocalDateTime createdDateTime, LocalDateTime lastModifiedDateTime, CompanyUserEntity createdByUserId, CompanyUserEntity lastModifiedByUserId, String note) {
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.createdByUserId = createdByUserId;
        this.lastModifiedByUserId = lastModifiedByUserId;
        this.note = note;
    }

    public PatientNoteEntity() {

    }
}
