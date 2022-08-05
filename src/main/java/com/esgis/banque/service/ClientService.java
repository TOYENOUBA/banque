/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esgis.banque.service;

import com.esgis.banque.model.Client;
import com.esgis.banque.model.Compte;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author TR7
 */
public interface ClientService {

    public Client saveClient(Client c);

    public Optional<Client> findById(String id);

    public List<Client> findAll();

    public void deleteClient(String id);

    public Client findByNom(String nom);

}
