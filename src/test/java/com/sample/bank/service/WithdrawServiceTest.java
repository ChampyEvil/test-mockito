/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.bank.service;

import com.sample.bank.model.BankAccount;
import com.sample.bank.repo.BankAccountRepo;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author GuutonG
 */
public class WithdrawServiceTest {
    
    private WithdrawService withdrawService;
    private BankAccount account;
    private BankAccountRepo bankAccountRepo;
    
    public WithdrawServiceTest() {
    }
    
    @Before
    public void setUp() {
        withdrawService = new WithdrawServiceImpl();
        bankAccountRepo = Mockito.mock(BankAccountRepo.class);
        
        account = new BankAccount();
        account.setBalance(1000d);
        
        Mockito.when(bankAccountRepo.findOne(1)).thenReturn(account);
        
        ReflectionTestUtils.setField(withdrawService, "bankAccountRepo", bankAccountRepo);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = RuntimeException.class)
    public void have1000_widthdraw_1005_should_raise_exception() {
        Double balance = withdrawService.withdraw(1, 1005d);
    }
    
    @Test
    public void have1000_widthdraw_500_should_remain_500() {
        double balance = withdrawService.withdraw(1, 500d);
        Assertions.assertThat(balance).isEqualTo(500);
    }
    
    @Test
    public void have1000_widthdraw_1000_should_remain_0() {
        double balance = withdrawService.withdraw(1, 1000d);
        Assertions.assertThat(balance).isEqualTo(0);
    }
    
    @Test
    public void demo_verify() {
        account = Mockito.mock(BankAccount.class);
        Mockito.when(account.getBalance()).thenReturn(1000d);
        Mockito.when(bankAccountRepo.findOne(1)).thenReturn(account);
        ReflectionTestUtils.setField(withdrawService, "bankAccountRepo", bankAccountRepo);
        
        double balance = withdrawService.withdraw(1, 500d);
        Mockito.verify(account).setBalance(500d);
    }
}
