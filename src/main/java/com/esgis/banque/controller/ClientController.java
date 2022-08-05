/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.banque.controller;

import com.esgis.banque.model.Client;
import com.esgis.banque.service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TR7
 */ @RestController
@RequestMapping("/api/clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public ResponseEntity<Client> createCateg(@RequestBody Client c) {
        try {
            Client categ = clientService.saveClient(c);
                    return  new ResponseEntity<>(categ, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/getClient/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Client>> getCateegorie(@PathVariable("id") String id ) { 
        try {
            Optional<Client> categ = clientService.findById(id);
                    return  new ResponseEntity<>(categ, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
@RequestMapping(value = "/getAllClient", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAll() {
        try {
            List<Client> categories = clientService.findAll();
            if(categories.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.GET)
     public ResponseEntity<Object> deleteCateegorie(@PathVariable("id") String id ) { 
        try {
        clientService.deleteClient(id);
           return  new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}


