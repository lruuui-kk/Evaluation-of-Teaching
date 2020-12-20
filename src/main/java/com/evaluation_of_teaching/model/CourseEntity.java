package com.evaluation_of_teaching.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class CourseEntity {
    @Id
    private Integer course_id;
    private String name;
    private String dept;
    private String term;
    private Date start_time;
    private Date end_time;
    private String place;
    private Integer num;
    private Integer teacher_id;
}
