package com.yh.mapper.one2one;

import com.yh.model.one2one.Passenger;

/**
 * ClassName:PassengerMapper.xml
 * Package:com.yh.mapper
 * Time: 2024/5/31
 */
public interface PassengerMapper {

    /**
     * 根据id查询
     * @param id  旅客id
     * @return 旅客信息
     */
    Passenger findById(Integer id);
}
