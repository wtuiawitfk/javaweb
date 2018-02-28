package smis.servlet;

import com.sun.xml.internal.bind.v2.model.core.ID;
import smis.dao.IStudentDao;
import smis.dao.impl.StudentDaoImpl;
import smis.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class deleteStudentServlet extends HttpServlet {
    private IStudentDao dao;

    @Override
    public void init() throws ServletException {
        this.dao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.valueOf(req.getParameter("id"));
        dao.delete(id);
        req.getRequestDispatcher("/list").forward(req, resp);
    }
}
