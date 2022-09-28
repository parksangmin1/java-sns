package boardlike.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardlike.BoardLikeDAO;
import boardlike.BoardLikeDTO;


@WebServlet("/boardlike")
public class BoardLikeController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비동기
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 비동기
		System.out.println("옴");
		PrintWriter out = response.getWriter();
		out.print("boardlikecontroller");
		
		HttpSession session = request.getSession();
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardWriterId = request.getParameter("userId");
		String userId = (String) session.getAttribute("id");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		
		String like = request.getParameter("like");
		
		
		System.out.println("" + userId);
		System.out.println("" + boardWriterId);
		System.out.println("timestamp" + timestamp);
		System.out.println("like:"+like);
		
		
		boolean result = false;
		
		
		// 
//		try {
//			// like_flag : default 0
//			// board_like_id : auto increase
//			result = BoardLikeDAO.likeBoard(new BoardLikeDTO(0, boardId, userId, timestamp, like));
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		
		if(result) {
			ArrayList<BoardLikeDTO> likeList;
			try {
				likeList = BoardLikeDAO.getAllLikeBoard();
				request.setAttribute("likeList", likeList);
				request.getRequestDispatcher("boardList.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ;
		} else {
			request.getRequestDispatcher("boardList.jsp").forward(request, response);
		}
		
		
	
	}

}
