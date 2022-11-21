package app.zainal.com.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.zainal.com.model.Transaction;
import app.zainal.com.repository.TransactionRepository;

@RequestMapping("/transaction")
@RestController
public class TransactionController {

	@Autowired
	private TransactionRepository repo;

	@PostMapping("/create")
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {

		transaction.setId(null);
		transaction.setTime(Timestamp.valueOf(LocalDateTime.now()));

		repo.save(transaction);

		return ResponseEntity.status(201).build();
	}

	@GetMapping("/get-transactions/{id}")
	public ResponseEntity<?> getAllTransactions(@PathVariable Long id) {

		List<Transaction> records = repo.findByUserId(id);

		if (records == null) {
			return ResponseEntity.status(400).body("No records found");
		}

		return ResponseEntity.status(200).body(records);
	}

}
