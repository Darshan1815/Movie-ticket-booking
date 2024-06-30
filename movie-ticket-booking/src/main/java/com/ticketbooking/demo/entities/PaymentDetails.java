package com.ticketbooking.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PaymentDetails {

	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToOne
	    private Bookings booking;

	    private String paymentMethod;

	    private BigDecimal amount;

	    private LocalDateTime paymentDate;

	    private String transactionId;

	
	
}
