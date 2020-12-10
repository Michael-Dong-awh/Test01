package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDaoImpl;
import entity.NewsInfo;
import entity.Page;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentpage = request.getParameter("currentpage");
		UserDaoImpl ui = new UserDaoImpl();
		Page page = new Page();
		int count =  ui.getNewsCount();
		page.setSumsize(count);
		//三目运算
		page.setLastpage(page.getSumsize()%page.getPagesize() == 0?page.getSumsize()/page.getPagesize():page.getSumsize()/page.getPagesize()+1);
		page.setCurrentpage(Integer.parseInt(currentpage));
		List<NewsInfo> list = ui.getNewsByPage(page);
		//把分页实体存储request作用域
		request.setAttribute("page", page);
		
		request.setAttribute("list", list);
		//转发
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
