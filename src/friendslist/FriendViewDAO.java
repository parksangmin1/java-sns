package friendslist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class FriendViewDAO {
	public static ArrayList<String> getnamesByUserid(String usersid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT friend_id from friend where user_id = ?";
		ArrayList<String> id = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usersid);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				id.add(rset.getString("friend_id"));
			}
			
			
		} finally {
			DBUtil.close(con, pstmt, rset);;
		}
		
		return id;
	}  
}
