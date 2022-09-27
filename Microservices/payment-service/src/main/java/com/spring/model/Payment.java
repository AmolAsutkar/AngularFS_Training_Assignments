package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PaymentDetails")
public class Payment {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String paymentStatus;
   private String transactionId;
   private int orderId;
   private double amount;
}
