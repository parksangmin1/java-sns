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
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update")
public class BoardUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");  
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String userId = (String) session.getAttribute("id");
		String title = request.getParameter("title");
		String text = request.getParameter("text");

		// 업데이트 된 값
		String updateTitle = request.getParameter("updateTitle");
		String updateText = request.getParameter("updateText");
		
		
		request.setAttribute("boardId", boardId);
		request.setAttribute("userId", userId);
		request.setAttribute("title", title);
		request.setAttribute("text", text);

		
		
		// 수정하면 실행 x
		if(updateTitle == null && updateText == null) {
			request.getRequestDispatcher("boardUpdate.jsp").forward(request, response);
		}
		
		
		boolean result = false;
		
		try {
			result = BoardDAO.updateBoard(boardId, userId, updateTitle, updateText);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "업데이트에 실패했습니다.");
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
		} else {
			request.setAttribute("error", "작성자 아이디가 일치하지 않아 게시글 수정이 불가능합니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		return;
	}
	
}
