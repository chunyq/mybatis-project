package com.yh.model.many2many;

import lombok.Data;

import java.util.List;

/**
 * ClassName:Subject
 * Package:com.yh.model.many2many
 * Time: 2024/6/2
 */
@Data
public class Subject {
    private Integer id;
    private String name;
    private Integer grade;

    private List<Student> students;

}
