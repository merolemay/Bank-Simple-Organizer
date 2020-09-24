package model;

public class Administrator {
		
	private String username;
	private String pasword;
	
	public Administrator(String u, String p) {
		username=u;
		pasword=p;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	
}
