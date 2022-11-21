package app.zainal.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.zainal.com.model.CheckingAccount;

@Repository
public interface CheckingRepository extends JpaRepository<CheckingAccount, Long>{
	
	@Query(value = "SELECT * FROM checking_account WHERE user_Id = ?1", nativeQuery = true)
	Optional<CheckingAccount> findByUserId(Long id);

}
