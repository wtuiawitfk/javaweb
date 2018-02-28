package smis.servlet;

import smis.dao.IStudentDao;
import smis.dao.impl.StudentDaoImpl;
import smis.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListStudentServlet extends HttpServlet {
    private IStudentDao dao;

    @Override
    public void init() throws ServletException {
        this.dao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = dao.list();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/view/student/listStudent.jsp").forward(req, resp);
    }
}
