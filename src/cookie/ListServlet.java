package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie/list")

public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //String username = req.getParameter("username");
        String username = null;
        //使用cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie c :
                cookies) {
            if ("username".equals(c.getName())) {
                username = c.getValue();
            }
        }
        out.print("欢迎" + username + "登陆<br/>");
        out.print("<a href='/cookie/content'>邮件1</a><br/>");
        out.print("<a href='/cookie/content'>邮件2</a><br/>");
        out.print("<a href='/cookie/content'>邮件3</a><br/>");
        out.print("<a href='/cookie/content'>邮件4</a><br/>");
    }
}
