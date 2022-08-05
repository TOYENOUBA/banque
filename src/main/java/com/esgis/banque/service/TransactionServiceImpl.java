/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.banque.service;
import com.esgis.banque.model.Transaction;
import com.esgis.banque.repository.CompteRepository;
import com.esgis.banque.repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TR7
 */
@Service 
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		
	}

    @Override
    public List<Transaction> findTransactionList(long numCompte) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

