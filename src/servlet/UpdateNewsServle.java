package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDaoImpl;
import entity.NewsInfo;

/**
 * Servlet implementation class UpdateNewsServle
 */
public class UpdateNewsServle extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String   newsid = request.getParameter("newsId");
		String   ntid = request.getParameter("ntid");
		String   ntitle = request.getParameter("ntitle");
		String   nauthor = request.getParameter("nauthor");
		String   nsummary = request.getParameter("nsummary");
		String   ncontent = request.getParameter("ncontent");
		NewsInfo ni  = new NewsInfo(Integer.parseInt(newsid),Integer.parseInt(ntid),ntitle,nauthor,nsummary,ncontent,"");
		UserDaoImpl ud = new UserDaoImpl();
		int flag = ud.updateNews(ni);
		if(flag > 0){
			//修改成功 进入到admin/admin.jsp  需要servlet请求
			//转发请求  存值
			//request.setAttribute("uname", "admin"); //setAttribute的方式
			//request.setAttribute("upwd", "admin");
			//request.getRequestDispatcher("login").forward(request, response);
			//response.sendRedirect("login?uname=admin&upwd=admin");
			//js方式
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out= response.getWriter();
			out.write("<script>");
			//请求资源有点问题
			out.write("location.href='/Zuoye03/hello?uname=admin&upwd=admin';");
			out.write("</script>");
			out.flush();
			out.close();
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
