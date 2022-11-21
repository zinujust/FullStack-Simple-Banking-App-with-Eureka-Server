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



import app.zainal.com.model.CheckingAccount;
import app.zainal.com.repository.CheckingRepository;

@RequestMapping("/checking")
@RestController
public class CheckingAccountController {

	@Autowired
	private CheckingRepository checkingRepo;

	@PostMapping("/add-account")
	public ResponseEntity<?> addAccount(@RequestBody CheckingAccount account) {

		account.setId(null);
		checkingRepo.save(account);
		
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/add")
	public ResponseEntity<?> addToAccount(@RequestBody CheckingAccount account) {
		
		Optional<CheckingAccount> userAccount = checkingRepo.findByUserId(account.getUserId());
		
		if (userAccount == null) {
			return ResponseEntity.status(400).body("User account not found");
		}
		
		userAccount.get().setBalance(userAccount.get().getBalance() + account.getBalance());
		
		checkingRepo.save(userAccount.get());
		
		return ResponseEntity.status(200).body(userAccount);
	}
	
	@PutMapping("/subtract")
	public ResponseEntity<?> deductToAccount(@RequestBody CheckingAccount account) {
		
		Optional<CheckingAccount> userAccount = checkingRepo.findByUserId(account.getUserId());
		
		if (userAccount == null) {
			return ResponseEntity.status(400).body("User account not found");
		}
		
		userAccount.get().setBalance(userAccount.get().getBalance() - account.getBalance());
		
		checkingRepo.save(userAccount.get());
		
		return ResponseEntity.status(200).body(userAccount);
	}
	
	@GetMapping("/balance/{id}")
	public ResponseEntity<?> getBalane(@PathVariable Long id){
		Optional<CheckingAccount> user = checkingRepo.findByUserId(id);
		
		if(user.isPresent()) {
			return ResponseEntity.status(200).body(user);
		}
		
		return null;
	}
}
