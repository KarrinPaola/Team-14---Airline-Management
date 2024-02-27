package AirlineManager;

public class User {
	
	private String password; 
	private String username;
	private String userID; 
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String password, String username, String userID) {
		this.password = password; 
		this.username = username; 
		this.setUserID(userID); 
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	} 
	
	
}
