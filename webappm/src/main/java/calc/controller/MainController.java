package calc.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.descriptor.*;

@WebServlet("/MainController")
public class MainController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		System.out.println("Main controller got post or get request");
		String action = req.getParameter("action");
		String number = req.getParameter("number");
		
		if(action != null) {
			if(action.equals("postinfo")) {
				System.out.println("postInfo");
				System.out.println(number);
			}
			if(action.equals("getinfo")) {
				System.out.println("getInfo");
				req.setAttribute("attr1", "lucky9");
				
			}
		}
		String url = "/calc.jsp" ;
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
		
		//direct to what page
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doPost(req, resp);
	}
	

}
