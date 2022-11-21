package app.zainal.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.zainal.com.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "SELECT * FROM transaction t WHERE t.user_id = ?1", nativeQuery = true)
	List<Transaction> findByUserId(Long id);
}
