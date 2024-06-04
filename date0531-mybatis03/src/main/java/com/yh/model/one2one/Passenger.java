package com.yh.model.one2one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName:Passenger
 * Package:com.yh.model
 * Time: 2024/5/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    private Integer id;
    private String name;
    private String sex;
    private Date birthday;

    private Passport passport;//存储对应的护照信息，关系属性
}
