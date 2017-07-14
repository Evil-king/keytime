package com.yepu.service;

import com.yepu.exception.BaseException;
import com.yepu.pojo.Person;


public interface PersonService {

    Person queryByParam(String name, String card, Integer userId) throws BaseException;
}
