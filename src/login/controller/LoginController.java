package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardDTO;
import login.LoginValidTest;
import user.User;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	String value;
	
	@Override
	public void init(ServletConfig config) {
		String value = config.getInitParameter("testParameter");
	}
	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
    	String id = request.getParameter("id");	
    	String pw = request.getParameter("pw");
    	
    

    	request.setAttribute("id", id);
    	request.setAttribute("pw", pw);
    	User usr = LoginValidTest.loginTest(id, pw);

    	HttpSession session = request.getSession();
		
		if (usr != null) {
			session.setAttribute("id", usr.getId());
			session.setAttribute("pw", usr.getPassword());
		}
		
		if(usr == null) {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert(\"로그인 실패\"); location.href=\"login.html\";</script>"); 
			writer.close();
		} else {
			try {
				ArrayList<BoardDTO> boardList = BoardDAO.getAllBoard();
				request.setAttribute("boardList", boardList);
				request.getRequestDispatcher("boardList.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
			
		}
	}

}
