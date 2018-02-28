package scope;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope/b")

public class BServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        //获取request域对象内的共享数据
        Object num_in_request = req.getAttribute("NUM_IN_REQUEST");
        out.print("request域对象内共享的数据：" + num_in_request+"<br/>");

        //获取session域对象内的共享数据
        Object num_in_session = req.getSession().getAttribute("NUM_IN_SESSION");
        out.print("session域对象内共享的数据：" + num_in_session+"<br/>");

        //获取application域对象内的共享数据
        Object num_in_application = req.getSession().getServletContext().getAttribute("NUM_IN_APPLICATION");
        out.print("session域对象内共享的数据：" + num_in_application+"<br/>");
    }
}
