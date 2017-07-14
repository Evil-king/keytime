package com.yepu.controller;

import com.yepu.exception.BaseException;
import com.yepu.pojo.Person;
import com.yepu.pojo.SearchMsg;
import com.yepu.service.PersonService;
import com.yepu.service.ISearchMsgService;
import com.yepu.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fox on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/query")
public class SearchMsgController {
    @Autowired
    private ISearchMsgService searchMsgService;
    @Autowired
    private PersonService personService;

    /**
     * 模糊查询
     */
    @RequestMapping(value = "/fuzzy",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String,Object>> fuzzyQuery(String name, Integer userId) throws BaseException{
        Map<String,Object> map = new HashMap<>();
        List<Person> personList= searchMsgService.selectByParam(name,userId);
        SearchMsg msg = searchMsgService.queryByUserId(userId);
        map.put("DataInfo",personList);
        map.put("Account",msg.getAccount());
        return ServerResponse.createBySuccess("成功",map) ;
    }

    /**
     * 精确查询
     */
    @RequestMapping(value = "/exact",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String,Object>> exactQuery(String name,String card,Integer userId) throws BaseException{
        Map<String,Object> map = new HashMap<>();
        Person person = personService.queryByParam(name,card,userId);
        map.put("DataInfo",person);
        return ServerResponse.createBySuccess("成功",map);
    }
}
