/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esgis.banque.repository;
import com.esgis.banque.model.Compte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author TR7
 */
@RepositoryRestResource
public interface CompteRepository extends MongoRepository<Compte, String>{
    Compte findByNumCompte(String numCompte);
}
