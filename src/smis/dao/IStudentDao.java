package smis.dao;

import smis.domain.Student;

import java.util.List;

public interface IStudentDao {
    void save(Student student);

    void delete(int id);

    void update(Long id,Student student);

    Student get(int id);

    List<Student> list();
}
