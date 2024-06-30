package com.ticketbooking.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.demo.config.JwtProvider;
import com.ticketbooking.demo.entities.User;
import com.ticketbooking.demo.repositories.UserRepository;
import com.ticketbooking.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	UserRepository userRepo;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByJwt(String jwt) {
		
   String email= JwtProvider.getEmailFromJwtToken(jwt);
		
		User user=userRepo.findByEmail(email);
		return user;
	}

}
