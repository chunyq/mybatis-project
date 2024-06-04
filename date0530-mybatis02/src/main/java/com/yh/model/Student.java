package com.yh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Student
 * Package:com.yh.model
 * Time: 2024/5/31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String sex;
    private Integer age;
    private String major;
    private String college;
}
