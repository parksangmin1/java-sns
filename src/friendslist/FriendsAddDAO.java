package friendslist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import user.User;
import util.DBUtil;

public class FriendsAddDAO {
public static boolean addfriends(FriendsDTO addfriends) throws SQLException{
		
		
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into friend(user_id,friend_id) values(?, ?);");
			
			
	        pstmt.setString(1, addfriends.getUserid());
	        pstmt.setString(2, addfriends.getFriendid());
			
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
