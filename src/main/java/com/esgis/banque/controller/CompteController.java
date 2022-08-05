/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.banque.controller;

import com.esgis.banque.model.Compte;
import com.esgis.banque.service.CompteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author TR7
 */
@RestController
@RequestMapping("/api/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;
    
    @PostMapping("/create")
    public ResponseEntity<Compte> createCateg(@RequestBody Compte c) {
        try {
            Compte cpt = compteService.saveCompte(c);
                    return  new ResponseEntity<>(cpt, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get")
    public ResponseEntity<List<Compte>> getAll() {
        try {
            List<Compte> categories = compteService.findAll();
            if(categories.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/update")
    public ResponseEntity<Compte> updateCateg(@RequestBody Compte c){
        try {
            Compte categ = compteService.saveCompte(c);
            return new ResponseEntity<>(categ, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/solde/{numCompte}")
    public ResponseEntity<Double> getSolde(@PathVariable String numCompte){
        try {
            Compte cmpt = compteService.findByNumCompte(numCompte);
            return new ResponseEntity<>(cmpt.getSolde(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PostMapping("/deposer/{numCompte}/{montant}")
    public ResponseEntity<Compte> deposer(@PathVariable String numCompte,@PathVariable double montant){
    try {
            Compte cmpt = compteService.findByNumCompte(numCompte);
            double temp= cmpt.getSolde();
            cmpt.setSolde(temp+montant);
            Compte c =compteService.saveCompte(cmpt);
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/retirer/{numCompte}/{montant}")
    public ResponseEntity<Compte> retirer(@PathVariable String numCompte,@PathVariable double montant){
    try {
            Compte cmpt = compteService.findByNumCompte(numCompte);
            double temp= cmpt.getSolde();
            cmpt.setSolde(temp-montant);
            Compte c =compteService.saveCompte(cmpt);
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/deplacer/{source}/{destination}/{montant}")
    public ResponseEntity<String> deplacer(@PathVariable String source,@PathVariable String destination,@PathVariable double montant){
    try {
            Compte cSource = compteService.findByNumCompte(source);
            Compte cDestination = compteService.findByNumCompte(destination);
            
            double t1 =cSource.getSolde();
            double t2 =cDestination.getSolde();
            
            cSource.setSolde(t1-montant);
            cDestination.setSolde(t2+montant);
            
            cSource =compteService.saveCompte(cSource);
            cDestination =compteService.saveCompte(cDestination);
            return new ResponseEntity<>("operation effectuer", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/virement/{source}/{destination}/{montant}")
    public ResponseEntity<String> virement(@PathVariable String source,@PathVariable String destination,@PathVariable double montant){
    try {
            Compte cSource = compteService.findByNumCompte(source);
            Compte cDestination = compteService.findByNumCompte(destination);
            
            double t1 =cSource.getSolde();
            double t2 =cDestination.getSolde();
            
            cSource.setSolde(t1-montant);
            cDestination.setSolde(t2+(montant-montant*0.02));
            
            cSource =compteService.saveCompte(cSource);
            cDestination =compteService.saveCompte(cDestination);
            return new ResponseEntity<>("virement effectuer", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
