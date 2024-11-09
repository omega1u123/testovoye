package org.example.testovoye.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company_user")
public class CompanyUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "login")
    public String login;

    public CompanyUserEntity(String login) {
        this.login = login;
    }

    public CompanyUserEntity() {

    }
}
