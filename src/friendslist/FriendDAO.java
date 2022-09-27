package friendslist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBUtil;

public class FriendDAO {
	public static ArrayList<FriendsDTO> getAllData() throws SQLException{
		Connection con = null; 
		Statement stmt = null;
		ResultSet rset = null; 
		
		ArrayList<FriendsDTO> allData;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			
			
			rset = stmt.executeQuery("SELECT * FROM friend;");
			
			allData = new ArrayList<FriendsDTO>();
			while(rset.next()) {
				allData.add(new FriendsDTO(rset.getString(1),rset.getString(2)));				
			}
		
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		
		return allData;
		
	}
	
	public static void main(String[] args) {
		try {
			for(FriendsDTO user: getAllData()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
