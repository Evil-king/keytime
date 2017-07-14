package com.yepu.dao;

import com.yepu.pojo.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {

    //模糊查询
    List<Person> queryByName(@Param("name") String name);

    int getCount();

    //精确查询
    Person queryByParam(Person person);

    int update(Person pp);
}