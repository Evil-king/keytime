package com.yepu.dao;

import com.yepu.pojo.UpLoad;

public interface UpLoadMapper {


    int insert(UpLoad record);

    UpLoad selectByUserId(Integer userId);

    int updateById(UpLoad record);

    UpLoad queryByUserId(Integer userid);

    UpLoad selectByParam(UpLoad upLoad);
}