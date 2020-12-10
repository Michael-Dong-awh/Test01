package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDaoImpl;

/**
 * Servlet implementation class DeleteNewsServlet
 */
public class DeleteNewsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String newsId = request.getParameter("newsId");
		UserDaoImpl bdi=new UserDaoImpl();
		int flag=bdi.delNewsInfoById(Integer.parseInt(newsId));
		if(flag>0){
			response.sendRedirect("del.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
