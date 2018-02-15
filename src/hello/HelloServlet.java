package hello;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet implements Servlet {
    //必须公共无参
    public HelloServlet() {
        System.out.println("构造器！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello hello");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁了！");
    }
}
