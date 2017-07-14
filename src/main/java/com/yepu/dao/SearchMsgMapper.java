package com.yepu.dao;

import com.yepu.pojo.SearchMsg;
import org.apache.ibatis.annotations.Param;

public interface SearchMsgMapper {

    int insert(SearchMsg searchMsg);

    SearchMsg selectByPrimaryKey(Integer id);


    int getMsgDayCount();

    int update(SearchMsg searchMsg);

    //根据userId查询对象是否存在
    SearchMsg queryByUserId(@Param("userId") Integer userId);
}