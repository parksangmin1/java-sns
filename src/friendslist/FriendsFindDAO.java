package friendslist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;


public class FriendsFindDAO {
	public static List<String> getnameByUserid(String names) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT user_id FROM USER WHERE name = ?";
		List<String> id = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, names);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				id.add(rset.getString("user_id"));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);;
		}
		
		return id;
	}  
}
