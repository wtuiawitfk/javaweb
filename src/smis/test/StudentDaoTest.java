package smis.test;

import org.junit.jupiter.api.Test;
import smis.dao.IStudentDao;
import smis.dao.impl.StudentDaoImpl;
import smis.domain.Student;

import java.util.List;

public class StudentDaoTest {
    IStudentDao dao = new StudentDaoImpl();
    @Test
    void testSave() {
        Student stu = new Student("小明", 12);
        dao.save(stu);
    }

    @Test
    void testDelete() {
        dao.delete(5);
    }

    @Test
    void testUpdate() {
        Student stu = new Student("大鱼儿", 35);
        dao.update(3L, stu);
    }

    @Test
    void testList() {
        List<Student> list = dao.list();
        System.out.println(list);
    }
    @Test
    void testGet() {
        Student student = dao.get(2);
        System.out.println(student);
    }
}
