package entity;

public class Role implements Entity {

	private static final long serialVersionUID = -8904794364882651716L;
	
	private User user;
	private String roleName;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
