package app.zainal.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullname;
	private String phoneNumber;
	
	@Column(unique = true)
	private String email;
	private String address;
	private String password;

	public BankUser() {
	}

	public BankUser(Long id, String fullname, String phoneNumber, String email, String address,
			String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format(
				"BankUser [id=%s, fullname=%s, phoneNumber=%s, email=%s, address=%s, password=%s]", id,
				fullname, phoneNumber, email, address, password);
	}
}
