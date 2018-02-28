package smis.dao.impl;

import smis.Handler.BeanHandler;
import smis.Handler.ListHandler;
import smis.dao.IStudentDao;
import smis.domain.Student;
import smis.template.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public void save(Student student) {
        try {
            JdbcTemplate.save(student);
        } catch (Exception e) {
            throw new RuntimeException("储存数据错误！", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from t_student where id=?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Long id,Student student) {
        String sql = "update t_student set name=?,age=? where id=?;";
        JdbcTemplate.update(sql, student.getName(), student.getAge(), id);
    }

    @Override
    public Student get(int id) {
        String sql = "select * from t_student where id=?";
        Student query = JdbcTemplate.query(sql, new BeanHandler<>(Student.class), id);
        return query;
    }

    @Override
    public List<Student> list() {
        String sql = "select * from t_student;";
        List list = JdbcTemplate.query(sql, new ListHandler<>(Student.class));
        return list;
    }

}
