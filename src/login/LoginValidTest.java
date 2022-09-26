package login;

import user.User;

public class LoginValidTest {
	public static User loginTest(String id, String pw) {
		return LoginDAO.getUser(id, pw);
	}
}
