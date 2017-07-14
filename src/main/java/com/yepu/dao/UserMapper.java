package com.yepu.dao;

import com.yepu.pojo.User;

public interface UserMapper {

    int insertUser(User record);

    int updateById(User record);

    int checkPhone(String phone);

    int checkLoginPhone(String phone);



}