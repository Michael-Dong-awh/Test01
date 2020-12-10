package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.UserDaoImpl;
import entity.NewsInfo;
import entity.Page;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
/*	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("调用了service服务");
		String uname = request.getParameter("uname");
		System.out.println("通过service服务获取用户名："+uname);
		//设置字符编码集
		request.setAttribute("name", uname);
		request.getRequestDispatcher("one.jsp").forward(request, response);
		
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取数据
		String userName =request.getParameter("userName");
		String pwd =request.getParameter("pwd");
		
		if("admin".equals(userName) && "123456".equals(pwd) ){
			response.getWriter().print("欢迎您"+userName+"再次回来！");
		}else{
			response.sendRedirect("login.html");
		
	}*/
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  /*request.setCharacterEncoding("utf-8");*/
		/*//获取全局参数 key-value
		String encoding = this.getServletContext().getInitParameter("encoding");*/
		request.setCharacterEncoding("utf-8");
		//用户名
		  String uname =  request.getParameter("uname");
		//密码
		  String upwd =  request.getParameter("upwd");
		  UserDaoImpl us =  new UserDaoImpl();
		//验证通过了，跳转admin/admin.jsp  跳转（转发），走的是服务器
		  boolean  flag = us.validateUser(uname, upwd);
		if(flag){
			//存值
			
			//request.setAttribute("uname", uname);
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(20*10);
			session.setAttribute("uname", uname);
			//首页数据储存起来
			Page page = new Page();		
			int count =  us.getNewsCount();
			page.setSumsize(count);
			//三目运算
			page.setLastpage(page.getSumsize()%page.getPagesize() == 0?page.getSumsize()/page.getPagesize():page.getSumsize()/page.getPagesize()+1);
			page.setCurrentpage(1);//首页
			//把分页实体存储在request作用域
			request.setAttribute("page", page);
			List<NewsInfo> list = us.getNewsByPage(page);
			
			request.setAttribute("list", list);
			//验证通过跳转admin/admin.jsp
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}else{ 
			//从服务器写东西到浏览器（客户端），给浏览器一个表头协议
			response.setContentType("text/html;charset=UTF-8");
			//写到浏览器中
			//response响应的时候，可以得到一个io流
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户名或密码不正确！');");
			out.write("location.href='hello';");
			out.write("</script>");
		}
	}

}
