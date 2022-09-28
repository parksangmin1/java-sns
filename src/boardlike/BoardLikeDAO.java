package boardlike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBUtil;

public class BoardLikeDAO {
	public static ArrayList<BoardLikeDTO> getAllLikeBoard() throws SQLException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<BoardLikeDTO> allData;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from board_like");
			
			allData = new ArrayList<BoardLikeDTO> ();
			
			while(rset.next()) {
				allData.add(new BoardLikeDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getTimestamp(4), rset.getInt(5)));
			} 
		}finally {
			DBUtil.close(con, stmt, rset);
		}
		return allData;
	}
	
	public static boolean likeBoard(BoardLikeDTO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			System.out.println(vo.getLikeFlag());
			
			pstmt = con.prepareStatement("insert into board_like (board_Id, user_Id, click_date, like_flag) values (?, ?, ?, ?)");
			pstmt.setInt(1, vo.getBoardId());
			pstmt.setString(2, vo.getUserId());
			pstmt.setTimestamp(3, vo.getClickDate());
			pstmt.setInt(4, vo.getLikeFlag());
			
			int count = pstmt.executeUpdate();
			if(count != 0) {
				result = true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		
		return result;
		
	}
	
	
	public static void main(String[] args) {

	}

}
