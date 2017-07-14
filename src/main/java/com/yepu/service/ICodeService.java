package com.yepu.service;


import com.yepu.exception.BaseException;
import com.yepu.pojo.Code;
import com.yepu.vo.ServerResponse;

public interface ICodeService {

    ServerResponse<Code> sendCodebyType(String phone, int type);

    public void sendSms(String mobiles, String content,Integer type) throws BaseException;

    public void sendSms(String mobiles, String content, long task_id,Integer type) throws BaseException ;

    public void sendSms(String mobiles, String content, String sp_code,Integer type) throws BaseException;
}
