package com.yepu.serviceimpl;


import com.yepu.dao.PersonMapper;
import com.yepu.dao.SearchMsgMapper;
import com.yepu.p_do.HomeCount;
import com.yepu.service.IHomeService;
import com.yepu.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iHomeService")
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private SearchMsgMapper searchMsgMapper;


    @Override
    public ServerResponse<HomeCount> getHomeMain() {
        int personCount=personMapper.getCount();
        int msgCount=searchMsgMapper.getMsgDayCount();
        HomeCount homeCount=new HomeCount(personCount,msgCount);
       return ServerResponse.createBySuccess("登录成功",homeCount);
    }
}
