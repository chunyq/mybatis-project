package com.yh.model.many2many;

import lombok.Data;

import javax.security.auth.Subject;
import java.util.List;

/**
 * ClassName:Student
 * Package:com.yh.model.many2many
 * Time: 2024/6/2
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;

    private List<Subject> subjects;

}
