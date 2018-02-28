package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie/login")

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //----------------使用cookie-------------------
        Cookie cookie = new Cookie("username", username);
        resp.addCookie(cookie);
        //--------------------------------------

        if ("admin".equals(username) && "123456".equals(password)) {
            out.print("<h2>欢迎" + username + "登陆</h2><br/>");
            out.print("<a href='/cookie/list'>收件箱(5)</a>");
        }
    }
}
