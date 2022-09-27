package com.citiustec.srp.bad;

public class SingleResponsibilityPrinciple2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// the variou responsibilities are
//1 login/Logout
//2 passwordhashing
//3 userstore
class LoginService{
	private String LoggedINUser="";
	
	public void loginUser(String username,String password) {
		String hash=hashPassword(password);
		if(userExistinDB(username,hash))
			LoggedINUser=username;
	}
	
	public void logout() {
		LoggedINUser="";
	}
	
	public String getLoggedinuser() {
		return LoggedINUser;
	}
	public String hashPassword(String password) {
		return null;
	}
	public boolean userExistinDB(String username,String password) {
		return false;
	}
	
}

