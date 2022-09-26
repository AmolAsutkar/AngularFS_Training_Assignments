package com.citiustech.dao;

import java.util.List;

import com.citiustech.entity.Account;
import com.citiustech.entity.TransactionDetails;

public class AccountTransactionDao extends GenericDao {

	public List<TransactionDetails> fetchMiniStatement(int accountId){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class
				.createQuery("select t from TransactionDetails t where t.account.account_id=:id order by t.Dateandtime Desc",TransactionDetails.class)    //JPQL query is independent of database
				.setParameter("id", accountId)
				.setMaxResults(5)
				.getResultList();
	}
	public List<Account> fetchAccountByTransaction(int count){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class
				.createQuery("select a from Account a where a.transactiondetails.size>=:count ",Account.class)    //JPQL query is independent of database
				.setParameter("count", count)
				.setMaxResults(5)
				.getResultList();
	}
	
	
}
