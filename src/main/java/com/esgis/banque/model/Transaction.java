/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.banque.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author TR7
 */
@Document("transactions")
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
  @Id
  private long Id;
  private double montant;
  private List<Compte> compte;
}
