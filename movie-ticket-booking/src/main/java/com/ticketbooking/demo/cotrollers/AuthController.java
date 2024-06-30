package com.ticketbooking.demo.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.demo.config.JwtProvider;
import com.ticketbooking.demo.entities.User;
import com.ticketbooking.demo.repositories.UserRepository;
import com.ticketbooking.demo.service.CustomUserDetailsService;
import com.ticketbooking.demo.service.UserService;



@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailsService customUserDetails;
	
	@PostMapping("/register")
	public AuthResponse createUser(@RequestBody User user) throws Exception {
		
		System.out.println("user Registration method called");
     User newUser=new User();

   User ifExist= userRepo.findByEmail(user.getEmail());
   
   if(ifExist!=null) {
	   
	   throw new Exception ("This email is already registered with another account");
	   
   }

		newUser.setEmail(user.getEmail());
		newUser.setUserRole(user.getUserRole());
		newUser.setName(user.getName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User savedUser= userRepo.save(newUser);
		
		Authentication authentication= new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		
		String token = JwtProvider.generateToken(authentication);
		
		AuthResponse res= new AuthResponse(token, "Register Success");
		
		return res;
	}
	
	
	
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest) {
		
		
		Authentication authentication= authenticate(loginRequest.getEmail(), loginRequest.getPassword());
		
		
		
      String token = JwtProvider.generateToken(authentication);
		
		AuthResponse res= new AuthResponse(token, "Login Success");
		
		return res;
		
		
	}

	private Authentication authenticate(String email, String password) {
		
		UserDetails userDetails = customUserDetails.loadUserByUsername(email);
		
		if(userDetails==null) {
			throw new BadCredentialsException("Bad Credentials");
			
		}
		
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			
			throw new BadCredentialsException("Password not matched");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
	
	

}
