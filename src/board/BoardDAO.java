package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBUtil;

public class BoardDAO {
	// 모든 게시글 불러오기
	public static ArrayList<BoardDTO> getAllBoard() throws SQLException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<BoardDTO> allData;
		try {
			con = DBUtil.getConnection();
			
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("SELECT * FROM BOARD");
			
			allData = new ArrayList<BoardDTO> ();
			
			while(rset.next()) {
				allData.add(new BoardDTO(rset.getInt(1), rset.getString(2), rset.getString(3),rset.getString(4)));
			}
			
			
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return allData;
	}
	
	
	
	// 게시글 작성
	@SuppressWarnings("null")
	public static boolean writeBoard(BoardDTO vo) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into board (user_id, title, text)values (?, ?, ?)");
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getText());
			
			int count = pstmt.executeUpdate();
			if(count != 0) {
				result = true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}	
	
	
	// 게시글 삭제
	public static boolean deleteBoard(int boardId, String userId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from board where board_id = ? and user_id = ?");
			
			pstmt.setInt(1, boardId);
			pstmt.setString(2, userId);
			
			int count = pstmt.executeUpdate();
			
			if (count !=0) {
				result = true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	// 게시글 수정
	public static boolean updateBoard(int boardId, String userId, String title, String text) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			// 쿼리문 실수
			pstmt = con.prepareStatement("update board set title = ? , text = ? where board_id = ? and user_id = ? ");
			
			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.setInt(3, boardId);
			pstmt.setString(4, userId);
			
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
		try {
			for(BoardDTO board : getAllBoard()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
