package scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scope/a")
public class AServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //使用request作用域共享数据
        Object num_in_request = req.getAttribute("NUM_IN_REQUEST");
        if (num_in_request != null) {
            Integer inum = Integer.valueOf(num_in_request.toString());
            req.setAttribute("NUM_IN_REQUEST", inum + 1);
        } else {
            req.setAttribute("NUM_IN_REQUEST",1);
        }
        //-------------------------------------------------
        //使用session作用域共享数据
        Object num_in_session = req.getSession().getAttribute("NUM_IN_SESSION");
        if (num_in_session != null) {
            Integer inum = Integer.valueOf(num_in_session.toString());
            req.getSession().setAttribute("NUM_IN_SESSION", inum + 1);
        } else {
            req.getSession().setAttribute("NUM_IN_SESSION",1);
        }

        //-------------------------------------------------
        //使用application作用域共享数据
        Object num_in_application = req.getSession().getServletContext().getAttribute("NUM_IN_APPLICATION");
        if (num_in_application != null) {
            Integer inum = Integer.valueOf(num_in_session.toString());
            req.getSession().getServletContext().setAttribute("NUM_IN_APPLICATION", inum + 1);
        } else {
            req.getSession().getServletContext().setAttribute("NUM_IN_APPLICATION",1);
        }

        //使用请求转发
        req.getRequestDispatcher("/scope/b").forward(req, resp);
    }
}
