package org.example.testovoye.domain.repository;

import org.example.testovoye.domain.model.CompanyUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyUserRepository extends CrudRepository<CompanyUserEntity, Integer> {

    CompanyUserEntity findByLogin(String login);

}
