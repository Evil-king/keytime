package com.yepu.dao;

import com.yepu.pojo.Code;

public interface CodeMapper {

    int insertCode(Code record);

    Code selectByPhoneAndType(String phone,Integer id);

    int updateByPhoneAndType(Code record);

    int getCodeByPhoneAndType(String phone,Integer id);

}