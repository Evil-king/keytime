package com.yepu.service;

import com.yepu.exception.BaseException;
import com.yepu.pojo.Person;
import com.yepu.pojo.SearchMsg;

import java.util.List;

/**
 * Created by Fox on 2017/6/3.
 */
public interface ISearchMsgService {
    /**
     * 模糊查询
     * @param name
     * @param userId
     * @return
     */
    public List<Person> selectByParam(String name, Integer userId) throws BaseException;

    SearchMsg queryByUserId(Integer userId);
}
