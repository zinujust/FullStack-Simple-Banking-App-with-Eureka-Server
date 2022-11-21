package app.zainal.com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.zainal.com.model.SavingsAccount;
import app.zainal.com.repository.SavingsRepository;

@RequestMapping("/savings")
@RestController
public class SavingsAccountController {

	@Autowired
	private SavingsRepository savingsRepo;
	
	@PostMapping("/add-account")
	public ResponseEntity<?> addSavingsAccount(@RequestBody SavingsAccount account){
		
		
		account.setId(null);
		savingsRepo.save(account);
		
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/add")
	public ResponseEntity<?> addToAccount(@RequestBody SavingsAccount account){
		
		Optional<SavingsAccount> userAccount = savingsRepo.findByUserId(account.getUserId());
		
		if(userAccount == null) {
			return ResponseEntity.status(400).body("User account not found");
		}
		
		userAccount.get().setBalance(userAccount.get().getBalance() + account.getBalance());
		
		savingsRepo.save(userAccount.get());
		
		return ResponseEntity.status(200).body(userAccount.get());
	}
	
	@PutMapping("/subtract")
	public ResponseEntity<?> deductFromAccount(@RequestBody SavingsAccount account){
		
		Optional<SavingsAccount> userAccount = savingsRepo.findByUserId(account.getUserId());
		
		if(userAccount == null) {
			return ResponseEntity.status(400).body("User account not found");
		}
		
		userAccount.get().setBalance(userAccount.get().getBalance() - account.getBalance());
		
		savingsRepo.save(userAccount.get());
		
		return ResponseEntity.status(200).body(userAccount);
	}
	
	@GetMapping("/balance/{id}")
	public ResponseEntity<?> getBalane(@PathVariable Long id){
		Optional<SavingsAccount> user = savingsRepo.findByUserId(id);
		
		if(user.isPresent()) {
			return ResponseEntity.status(200).body(user);
		}
		
		return null;
	}
}
