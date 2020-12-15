package com.evaluation_of_teaching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "choose_class")
public class ChooseClassEntity {

    @Id
    private Integer choose_class_id;
    private String student_id;
    private String course_id;
}
