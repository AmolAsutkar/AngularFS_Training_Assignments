package com.citiustech.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Account;
import com.citiustech.entity.TransactionDetails;

class TestAccountTransactionDao {

	@Test
	public void testfetchMiniStatement() {
		AccountTransactionDao atd=new AccountTransactionDao();
		List<TransactionDetails> list=atd.fetchMiniStatement(1);
		list.forEach(System.out::println);
	}
	
	@Test
	public void testfetchAccountByTransaction() {
		AccountTransactionDao atd=new AccountTransactionDao();
		List<Account> list=atd.fetchAccountByTransaction(4);
		list.forEach(System.out::println);
	}

}
