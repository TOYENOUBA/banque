/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.banque.service;

import com.esgis.banque.model.Compte;
import com.esgis.banque.repository.CompteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TR7
 */
@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;
    
    @Override
    public Compte saveCompte(Compte c) {
        return compteRepository.save(c);
    }

    @Override
    public Optional<Compte> findById(String id) {
        return compteRepository.findById(id);   
    }

    @Override
    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    @Override
    public void deleteCompte(String id) {
        Optional<Compte> data= findById(id);
        if(data.isPresent()){
            compteRepository.deleteById(id);
        }
    }
    
    @Override
    public Compte findByNumCompte(String numCompte){
        return compteRepository.findByNumCompte(numCompte);
    }

    public Compte saveCompte(Compte c, String idTitulaire) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void depot(String idCompte, double montant, double taux) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void retrait(String idCompte, double montant) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void virement(String idCompte, double montant, String idCompte2, double taux, double prixTransaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String afficher(String idCompte) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

