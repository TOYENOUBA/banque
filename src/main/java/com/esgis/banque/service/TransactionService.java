/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esgis.banque.service;

import com.esgis.banque.model.Transaction;
import java.util.List;

/**
 *
 * @author TR7
 */
public interface TransactionService {

    /**
     *
     * @param numCompte
     * @return
     */
    List<Transaction> findTransactionList(long numCompte);
	
	void saveTransaction(Transaction transaction);
	
}
