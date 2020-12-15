package com.evaluation_of_teaching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    private Integer teacher_id;
    private String username;
    private String password;
    private String name;
    private String sno;
    private String sex;
    private String dept;
}
