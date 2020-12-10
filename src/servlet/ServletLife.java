package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLife extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("get被调用了");
	//取出 只在当前servlet生效的k-v
	String name1 = this.getInitParameter("name1");
	System.out.println(name1);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPosts被调用了");
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("调用了service服务");
		super.service(arg0, arg1);
	}
	@Override
	public void destroy() {
		System.out.println("调用了destroy");
		super.destroy();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("servlet初始化成功");
		
	}

	
	
}
