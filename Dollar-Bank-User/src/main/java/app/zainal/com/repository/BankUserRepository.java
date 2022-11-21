package app.zainal.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.zainal.com.model.BankUser;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Long>{

	BankUser findByEmail(String email); 
	public Optional<BankUser> findUserByEmail(String username);
}
