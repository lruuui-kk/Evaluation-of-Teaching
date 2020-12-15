package com.evaluation_of_teaching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {
    @Id
    private Integer student_id;
    private String username;
    private String password;
    private String name;
    private String sno;
    private String sex;
    private String dept;
    private String stu_class;
    private List<CourseEntity> courseList;
}
