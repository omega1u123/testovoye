package org.example.testovoye.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient_profile")
public class PatientProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "old_client_guid")
    public String oldClientGuid;

    @Column(name = "status_id")
    public int statusId;
}
