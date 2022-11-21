package app.zainal.com.model;

import java.io.Serializable;

// response object for when we authenticate and return the JWT
public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String jwt;
	
	public AuthenticationResponse(String jwt, Long id) {
		this.jwt = jwt;
		this.id = id;
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}
