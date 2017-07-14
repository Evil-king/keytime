package com.yepu.serviceimpl;

import com.yepu.dao.PersonMapper;
import com.yepu.exception.BaseException;
import com.yepu.pojo.Person;
import com.yepu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    /**
     * 根据条件查询对象信息
     * @param name
     * @param card
     * @param userId
     * @return
     */
    public Person queryByParam(String name, String card, Integer userId) throws BaseException{
        if(name == null && name ==""){
            throw new BaseException("姓名不能为空");
        }
        if(card.length() < 18 ){
            throw new BaseException("身份证号不符合规格");
        }
        Person pp = new Person();
        pp.setName(name);
        pp.setCard(card);
        pp.setUserId(userId);
        Person person = personMapper.queryByParam(pp);
        if(person != null ){
            pp.setCheckedTimes(person.getCheckedTimes()+1);
            personMapper.update(pp);
        }else{
            throw new BaseException("您所查询的用户信息不存在");
        }
        return pp;
    }
}
