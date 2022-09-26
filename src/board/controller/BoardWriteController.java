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
 * Servlet implementation class BoardController
 */
@WebServlet("/write")
public class BoardWriteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. boardlist.jsp 에서 새로고침이 일어나면 게시글이 새로생긴다.
		request.setCharacterEncoding("UTF-8");  
		
		
		// 게시글 추가
		@SuppressWarnings("null")
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		
		boolean result = false;
		
		
		try {
			result = BoardDAO.writeBoard(new BoardDTO(0, id, title, text));
		} catch (SQLException e) {
			e.printStackTrace();
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
			// return을 줘야 jsp절차가 정상적으로 끝남
			return ;
		} else {
			request.getRequestDispatcher("boardwrite.jsp").forward(request, response);
		}
	}

}
