package friendslist.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friendslist.FriendViewDAO;

/**
 * Servlet implementation class FriendlistViewController
 */
@WebServlet("/friendlistview")
public class FriendListViewController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String usersid = (String)session.getAttribute("id");
		ArrayList<String> friendList = null;
		try {
			friendList = FriendViewDAO.getnamesByUserid(usersid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("friendList", friendList);
		
		request.getRequestDispatcher("friendlistview.jsp").forward(request, response);
		
	}

}
