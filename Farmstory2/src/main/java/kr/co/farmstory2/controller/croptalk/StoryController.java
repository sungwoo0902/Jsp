package kr.co.farmstory2.controller.croptalk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/croptalk/story.do")
public class StoryController extends HttpServlet{

	private static final long serialVersionUID = 1949764471964956853L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/croptalk/story.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
