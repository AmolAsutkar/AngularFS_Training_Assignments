package com.spring.service;

import com.spring.model.Order;
import com.spring.model.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
private Order order;
private Payment payment;
}
