package join.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import join.joinDAO;
import login.LoginValidTest;
import user.User;
import user.UserDAO;


@WebServlet("/joincontroller")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String value;
	
	@Override
	public void init(ServletConfig config) {
		String value = config.getInitParameter("testParameter");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, NumberFormatException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age =  Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String profile = request.getParameter("profile");
		
		//데이터값 입력 유무만 유효성 검증
		if(id == null || id.trim().length() == 0 ||
		   pw == null || pw.trim().length() == 0 ||
		   name == null || name.trim().length() == 0 ||
		   age == 0 ||
		   sex == null || sex.trim().length() == 0 ||
		   email == null || email.trim().length() == 0 ||
		   profile == null || profile.trim().length() == 0
				){
			
			response.sendRedirect("join.html");
			return;
		}
		boolean result = false;
		try {
			result = joinDAO.getUser(new User(id, pw, name, age, sex, email, profile , 0));
		} catch (Exception e) {
			request.setAttribute("error", "back");
		}
		if(result){
			response.sendRedirect("login.html"); 
		}else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert(\"회원가입 실패\"); location.href=\"join.html\";</script>"); 
			writer.close();
		}
	}
}
