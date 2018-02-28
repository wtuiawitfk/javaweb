package smis.domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("t_student")
@NoArgsConstructor
public class Student {
    private Long id;
    @Column("name")
    private String name;
    @Column("age")
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
