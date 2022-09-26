package board;

import java.sql.SQLException;

public class BoardService {
	public static boolean deleteBoard(int boardId, String userId) throws SQLException {
		return BoardDAO.deleteBoard(boardId, userId);
	}
	
//	public static boolean updateBoard(int boardId, String userId, String title, String text) {
//		return 
//	}
}
