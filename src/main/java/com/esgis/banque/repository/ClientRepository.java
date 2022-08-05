/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esgis.banque.repository;

import com.esgis.banque.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author TR7
 */
public interface ClientRepository extends MongoRepository<Client, String>{

   
}
