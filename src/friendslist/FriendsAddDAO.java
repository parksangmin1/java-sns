package friendslist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.User;
import util.DBUtil;

public class FriendsAddDAO {
public static boolean addfriends(FriendsDTO addfriends) throws SQLException{
		
		
		Connection con = null;	
		PreparedStatement pstmt = null;
		PreparedStatement addtest = null;
		ResultSet rset = null;
		boolean result = false;
		int count = 0;
		
		try {
			con = DBUtil.getConnection();
			addtest = con.prepareStatement("select friend_id from friend where user_id = ? and friend_id = ?");
			
			addtest.setString(1, addfriends.getUserid());
			addtest.setString(2, addfriends.getFriendid());
			
			rset = addtest.executeQuery();
	
			if(rset.next()) {
				System.out.println("친구추가 실패");
			}else {
				pstmt = con.prepareStatement("insert into friend(user_id,friend_id) values(?, ?);");
				
		        pstmt.setString(1, addfriends.getUserid());
		        pstmt.setString(2, addfriends.getFriendid());
				
		        count = pstmt.executeUpdate();	
			}
			

			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;	
	}
}
