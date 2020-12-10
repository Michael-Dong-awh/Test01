package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDaoImpl;
import entity.CommentInfo;

//继承HttpServlet
public class HelloServlet  extends HttpServlet{
	//重写doGet doPost方法
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//HttpServlet  就是jsp中的Request 
		//HttpServletResponse  就是jsp中的Response 
		request.setCharacterEncoding("utf-8");
		//定义传出给浏览器的格式
		response.setContentType("text/html;charset=utf-8");
		//取出访问请求中携带的参数
		String name =  request.getParameter("name");
		//System.out.println(name);
		//写出页面
		//jsp的out就是 PrintWriter
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>hello!servlet</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h1>"+name+"</h1>");
		writer.print("</body>");
		writer.print("</html>");
		System.out.println("接收到了用户Get方式请求");*/
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl us  = new	UserDaoImpl();
		List<CommentInfo> list = us.getCommentInfo();
		//存放1个集合接口
		request.setAttribute("list", list);
				//转发
		request.getRequestDispatcher("index.jsp").forward(request, response);

	/*	System.out.println("接收到了用户Post方式请求");*/
	
	}
	
	
	
}
