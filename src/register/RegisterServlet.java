package register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 模拟处理一个注册请求
 */
@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求参数编码
        req.setCharacterEncoding("utf-8");

        //根据参数名称来获取值
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");

        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(name + "-->" + password + "-->" + sex);
        for (int i = 0; i < hobbies.length; i++) {
            System.out.println(hobbies[i]);
        }
    }
}
