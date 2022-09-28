package friendslist.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friendslist.FriendsFindDAO;




@WebServlet("/friendsfindlist")
public class FriendsListFindController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String names = request.getParameter("names");
			List<String> id = FriendsFindDAO.getnameByUserid(names);
			if(id != null) {
				request.setAttribute("id", id);
				request.getRequestDispatcher("friendaddview.jsp").forward(request, response);
			}else {
				request.setAttribute("id", "존재하지 않는 친구");
				request.getRequestDispatcher("friendaddview.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			response.sendRedirect("friendaddfail.jsp");
		}
		
		
	}

}
