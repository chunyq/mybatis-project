package com.yh.model.one2one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName:Passport
 * Package:com.yh.model
 * Time: 2024/5/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    private Integer id;
    private String nationality;
    private Date expire;
}
