package kr.co.farmstory2.controller.croptalk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/croptalk/school.do")
public class SchoolController extends HttpServlet{

	private static final long serialVersionUID = 8481928768734299721L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/croptalk/school.jsp");
		dispatcher.forward(req, resp);
	
	}
}
