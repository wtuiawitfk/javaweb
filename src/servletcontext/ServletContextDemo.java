package servletcontext;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")

public class ServletContextDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servletcontextc对象的三种方法
        System.out.println(req.getSession().getServletContext());
        System.out.println(getServletContext());
        System.out.println(req.getServletContext());

        //获取全局参数
        String encoding = getServletContext().getInitParameter("encoding");
        System.out.println(encoding);
    }
}

