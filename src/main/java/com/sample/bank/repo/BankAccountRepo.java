/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.bank.repo;

import com.sample.bank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author GuutonG
 */
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {

    public BankAccount findByName(String id);
}
