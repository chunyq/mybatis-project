package com.yh.mapper.many2many;

import com.yh.model.many2many.Subject;

/**
 * ClassName:SubjectMapper
 * Package:com.yh.mapper.many2many
 * Time: 2024/6/2
 */
public interface SubjectMapper {

   Subject findSubjectById(Integer id);

}
