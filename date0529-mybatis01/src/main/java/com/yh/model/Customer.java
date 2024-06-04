package com.yh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Customer
 * Package:com.yh.model
 * Time: 2024/5/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String qq;
    private String email;
    private Integer status;
}
