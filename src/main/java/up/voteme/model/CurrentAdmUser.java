package up.voteme.model;

import up.voteme.domain.Userd;

public class CurrentAdmUser {
	private String userLogin;

	public CurrentAdmUser(Userd user){
		this.userLogin = user.getUserLogin();
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	
}
