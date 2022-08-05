/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esgis.banque.service;

import com.esgis.banque.model.Compte;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author TR7
 */
public interface CompteService {
    public Compte saveCompte(Compte c);
    public Optional<Compte> findById(String id);
    public List<Compte> findAll();
    public void deleteCompte(String id);
    public Compte findByNumCompte(String numCompte);
}