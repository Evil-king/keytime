package com.yepu.serviceimpl;

import com.yepu.dao.PersonMapper;
import com.yepu.dao.SearchMsgMapper;
import com.yepu.exception.BaseException;
import com.yepu.pojo.Person;
import com.yepu.pojo.SearchMsg;
import com.yepu.service.SearchMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 查询
 * Created by Fox on 2017/6/5.
 */
@Service
public class SearchMsgServiceImpl implements SearchMsgService {

    @Autowired
    private SearchMsgMapper searchMsgMapper;
    @Autowired
    private PersonMapper personMapper;

    private static final int num = 1;
    /**
     * 模糊条件查询
     *
     * @param name
     * @param userId
     * @return
     */
    @Transactional
    public List<Person> selectByParam(String name, Integer userId) throws BaseException{
        if (name == null && name == "") {
            throw  new BaseException(0,"查询条件不能为空");
        }
        SearchMsg msg = searchMsgMapper.queryByUserId(userId);
        List<Person> person = personMapper.queryByName(name);
        //如果pp对象不存在 则插入数据
        if(msg == null ){
            //关键字查询
            if (person.size() > 0) {
                //关键字查询到结果 查询次数+1
                SearchMsg searchMsg = new SearchMsg();
                searchMsg.setAccount(num);
                searchMsg.setSearchMsg(name);//关键字
                searchMsg.setUserId(userId);
                if (searchMsgMapper.insert(searchMsg) < 0) {
                    throw new BaseException("插入失败");
                }
            } else {
                throw new BaseException(1,"没有合适的查询结果");
            }
        }else{
            //如果pp对象存在 则更新数据
            SearchMsg searchMsg = new SearchMsg();
            searchMsg.setAccount(msg.getAccount()+1);
            searchMsg.setUserId(userId);
            if(searchMsgMapper.update(searchMsg) < 0){
                throw new BaseException(1,"更新失败");
            }
        }
        return person;
    }

    //通过userId查询对象信息
    public SearchMsg queryByUserId(Integer userId) {
        return searchMsgMapper.queryByUserId(userId);
    }
}
