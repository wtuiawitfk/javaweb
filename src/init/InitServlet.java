package init;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class InitServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获取初始化参数
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println(encoding);

        //获取多个初始化参数
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
