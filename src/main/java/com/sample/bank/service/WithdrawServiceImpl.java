/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.bank.service;

import com.sample.bank.model.BankAccount;
import com.sample.bank.repo.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GuutonG
 */
@Service
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private BankAccountRepo bankAccountRepo;

    @Override
    public Double withdraw(Integer accountId, Double amount) {
        BankAccount bankAccount = bankAccountRepo.findOne(accountId);
        if (bankAccount.getBalance() >= amount) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            return bankAccount.getBalance();
        } else {
            throw new RuntimeException("Balance Not enough.");
        }
    }
}
