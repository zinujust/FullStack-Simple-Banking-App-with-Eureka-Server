package app.zainal.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.zainal.com.SpringSecurity.JwtUtil;
import app.zainal.com.SpringSecurity.MyUserDetailsService;
import app.zainal.com.model.AuthenticationResponse;
import app.zainal.com.model.Authorize;
import app.zainal.com.model.BankUser;
import app.zainal.com.repository.BankUserRepository;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class AuthenticationController {
	
	// authentication manager -> validates/authenticates user credentials
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	BankUserRepository repo;
	
	@Autowired
	JwtUtil jwtUtil;

	
	// create the token at http://localhost:8080/authenticate 
	// send the username & password and try to generate a token as a response
	@PostMapping("/authenticate")
	public ResponseEntity<?> createJwtToken(@RequestBody Authorize request) throws Exception {
		
		// try to catch the exception for bad credentials, just so we can set our own
		// message when this doesn't work
		
		
		BankUser user = repo.findByEmail(request.getEmail());
		
		UserDetails userDetails = null;
		
			// as long as no exception was thrown, user is valid
			try {
				// make sure we have a valid user by checking their username and password
				if(encoder.matches(request.getPassword(), user.getPassword())) {
				
					userDetails = userDetailsService.loadUserByUsername(request.getEmail());
					
				}
			} catch (BadCredentialsException e) {
				// provide our own message on why login didn't work
				return ResponseEntity.status(400).build();
			}
		
		
		
		
		// load in the user details for that user
		

		// generate the token for that user
		final String jwt = jwtUtil.generateTokens(userDetails);

		// return the token
		return ResponseEntity.status(201).body( new AuthenticationResponse(jwt, user.getId()) );

	}
	
	
}








