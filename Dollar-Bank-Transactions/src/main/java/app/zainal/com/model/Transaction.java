package app.zainal.com.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TransactionType {
		DEPOSIT_SAVINGS, DEPOSIT_CHECKING, WITHDRAW_SAVINGS, WITHDRAW_CHECKING, TRANSFER_FROM_SAVINGS, TRANSFER_FROM_CHECKING
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;

	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private double balance;
	private Timestamp time;

	public Transaction() {
	}

	public Transaction(Long id, Long userId, TransactionType type, double balance, Timestamp time) {
		super();
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.balance = balance;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return String.format("Transaction [id=%s, userId=%s, type=%s, balance=%s, time=%s]", id, userId, type, balance,
				time);
	}

}
