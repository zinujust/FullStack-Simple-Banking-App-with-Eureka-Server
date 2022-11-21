package app.zainal.com.model;

public class Authorize {

	private String email;
	private String password;

	public Authorize() {
		super();
	}

	public Authorize(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Authorize [email=%s, password=%s]", email, password);
	}

}
