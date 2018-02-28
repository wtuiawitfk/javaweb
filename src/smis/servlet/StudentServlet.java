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

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private IStudentDao dao;
    @Override
    public void init() throws ServletException {
        this.dao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String cmd = req.getParameter("cmd");
        if ("saveOrUpdate".equals(cmd)) {
            this.saveOrUpdate(req, resp);
        } else if ("delete".equals(cmd)) {
            this.delete(req, resp);
        } else if ("edit".equals(cmd)) {
            this.edit(req, resp);
        } else {
            this.list(req, resp);
        }

    }
    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        if (id == null || "" == id) {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            Student stu = new Student(name, age);
            dao.save(stu);
            req.getRequestDispatcher("/student?cmd=list").forward(req, resp);
        } else {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            Long id2 = Long.valueOf(req.getParameter("id"));
            Student stu = new Student(name, age);
            dao.update(id2, stu);
            req.getRequestDispatcher("/student?cmd=list").forward(req, resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.valueOf(req.getParameter("id"));
        dao.delete(id);
        req.getRequestDispatcher("/student?cmd=list").forward(req, resp);
    }
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        if (id == null || "" == id) {
            req.getRequestDispatcher("/WEB-INF/view/student/addStudent.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/student/updateStudent.jsp").forward(req, resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        List<Student> list = dao.list();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/view/student/listStudent.jsp").forward(req, resp);
    }
}
