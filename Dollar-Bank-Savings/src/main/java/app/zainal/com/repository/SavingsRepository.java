package app.zainal.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.zainal.com.model.SavingsAccount;

@Repository
public interface SavingsRepository extends JpaRepository<SavingsAccount, Long> {

	@Query(value = "SELECT * FROM savings_account WHERE user_Id = ?1", nativeQuery = true)
	Optional<SavingsAccount> findByUserId(Long id);
	
}
