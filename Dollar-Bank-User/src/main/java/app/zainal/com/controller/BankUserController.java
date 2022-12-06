package app.zainal.com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.zainal.com.model.BankUser;
import app.zainal.com.repository.BankUserRepository;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class BankUserController {

	@Autowired
	private BankUserRepository bankUserRepo;

	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody BankUser user) {
		user.setId(null);
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		BankUser bUser = bankUserRepo.save(user);
		
		return ResponseEntity.status(201).body(bUser);
	}

	@GetMapping("/fetch-user-data/{id}")
	public ResponseEntity<?> getUserInfo(@PathVariable Long id) {

		Optional<BankUser> found = bankUserRepo.findById(id);

		if (!found.isPresent()) {
			return ResponseEntity.status(404).body("User not found");
		}

		return ResponseEntity.status(200).body(found.get());
	}

}
