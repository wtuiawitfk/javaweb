package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie/content")

public class ContentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        Cookie[] cookies = req.getCookies();
        String username = cookies[0].getValue();
        PrintWriter out = resp.getWriter();
        out.print("欢迎" + username+"</br>");
        out.print("大吉大利！今晚吃鸡！");
    }
}
