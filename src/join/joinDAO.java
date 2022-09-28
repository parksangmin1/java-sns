package join;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import user.User;

import util.DBUtil;

public class joinDAO {
public static boolean getUser(User join) throws SQLException{
		
		
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into user(user_id,password,name,age,sex,email,profile) values(?, ?, ?, ?, ?, ?,?);");
			
			
	        pstmt.setString(1, join.getId());
	        pstmt.setString(2, join.getPassword());
	        pstmt.setString(3, join.getName());
	        pstmt.setInt(4, join.getAge());
	        pstmt.setString(5, join.getSex());
	        pstmt.setString(6, join.getEmail());
	        pstmt.setString(7, join.getProfile());
			
			int count = pstmt.executeUpdate();			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;	
	}
}
