package com.citiustec.srp.good;

public class SingleResponsibilityPrinciple2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class UserStore{
	
	public boolean userExistinDB(String username,String password) {
		return false;
	}
}

class PasswordHashing{
	public String hashPassword(String password) {
		return null;
	}
}
class LoginService{
	private String LoggedINUser="";
	PasswordHashing hasher = new PasswordHashing();
	UserStore store = new UserStore();
	
	
	public void loginUser(String username,String password) {
		String hash=hasher.hashPassword(password);
		if(store.userExistinDB(username,hash))
			LoggedINUser=username;
	}
	
	public void logout() {
		LoggedINUser="";
	}
	
	public String getLoggedinuser() {
		return LoggedINUser;
	}
	
	
	
}