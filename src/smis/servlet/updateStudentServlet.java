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

@WebServlet("/update")
public class updateStudentServlet extends HttpServlet {
    private IStudentDao dao;

    @Override
    public void init() throws ServletException {
        this.dao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        Long id = Long.valueOf(req.getParameter("id"));
        Student stu = new Student(name, age);
        dao.update(id, stu);
        req.getRequestDispatcher("/list").forward(req, resp);
    }
}
