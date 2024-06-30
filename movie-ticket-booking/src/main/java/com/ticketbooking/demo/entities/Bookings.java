package com.ticketbooking.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Bookings {
	
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;

	@ManyToOne
	private User user;
	
	@OneToOne
	private Theater theater;
	
	@OneToOne
	private Screen screen;
	
	private LocalDateTime showTime;
	
	  @OneToOne
	    private PaymentDetails paymentDetails;
	
}
