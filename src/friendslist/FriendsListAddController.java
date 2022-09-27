package friendslist;

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
import join.joinDAO;
import user.User;


@WebServlet("/friendsaddlist")
public class FriendsListAddController extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("id");
		String friendid = request.getParameter("userId");
		
		boolean result = false;
		try {
			result = FriendsAddDAO.addfriends(new FriendsDTO(userid, friendid));
		} catch (Exception e) {
			request.setAttribute("error", "back");
		}
		ArrayList<BoardDTO> boardList;
		if(result){
			try {
				boardList = BoardDAO.getAllBoard();
				request.setAttribute("boardList", boardList);
				request.getRequestDispatcher("boardList.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
