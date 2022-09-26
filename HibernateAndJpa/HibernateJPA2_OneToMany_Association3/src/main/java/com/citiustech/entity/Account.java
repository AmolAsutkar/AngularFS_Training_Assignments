package com.citiustech.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int account_id;
	private String accname;
	private String type;
	private double balance;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private List<TransactionDetails> transactiondetails;
	
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	
	public List<TransactionDetails> getTransactions() {
		return transactiondetails;
	}

	public void setTransactions(List<TransactionDetails> transactions) {
		this.transactiondetails = transactions;
	}
	
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", accname=" + accname + ", type=" + type + ", balance=" + balance
				+ "]";
	}

}
