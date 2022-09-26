package board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardDTO;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete")
public class BoardDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String userId = (String)session.getAttribute("id");

		
		
		boolean result = false;
		
		try {
			result = BoardDAO.deleteBoard(boardId, userId);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "해당 게시글 삭제에 실패했습니다.");

		}
		
		if(result) {
			ArrayList<BoardDTO> boardlist;
			try {
				boardlist = BoardDAO.getAllBoard();
				request.setAttribute("boardList", boardlist);
				request.getRequestDispatcher("boardList.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// return 을 줘야 jsp절차가 정상적으로 끝남
			return ;
		} else {
			//삭제 버튼을 누른 후  에러 발생
			request.setAttribute("error", "작성자 아이디와 일치하지 않아 게시글 삭제에 실패했습니다.");
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	
	}

}
