package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.User;
import util.DBUtil;

public class LoginDAO {
	//로그인 검증
	public static User getUser(String id, String pw) {
		
		
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User usr = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from user where user_id = ? and password = ?");
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				usr = new User(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getInt(8));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return usr;
	}
}
