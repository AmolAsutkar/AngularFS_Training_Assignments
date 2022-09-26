package com.citiustech.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="TransactionDetails")
public class TransactionDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	
	private String type;
	private LocalDateTime Dateandtime;
	private double amount;
	
	
	@JoinColumn(name="Accountid_fkey")  // foreign key mapping
    @ManyToOne
    Account account;
	
	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public LocalDateTime getDateandtime() {
		return Dateandtime;
	}


	public void setDateandtime(LocalDateTime dateandtime) {
		Dateandtime = dateandtime;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transaction_id=" + transaction_id + ", type=" + type + ", Dateandtime="
				+ Dateandtime + ", amount=" + amount + "]";
	}


	
	

}
