package com.yepu.serviceimpl;

import com.yepu.dao.UserMapper;
import com.yepu.pojo.User;
import com.yepu.service.IUserService;
import com.yepu.util.StringUtil;
import com.yepu.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    private CodeServiceImpl codeService;

    //注册时，检查手机号是否可用，并发送验证码
    @Override
    public ServerResponse<String> getRegisterPhoneCode(String phone) {
        ServerResponse  validResponse=this.checkPhoneValid(phone);
        if(!validResponse.isSuccess()){
            return validResponse;
        }

   //     codeService.sendSms(phone,String.format(SmsMsg.TEMPLATE_CODE,"123456"), CodeEnum.Code_Type.Code_Login);
        validResponse=ServerResponse.createBySuccess("验证码发送成功");
        return validResponse;
    }


    //登录时，检查手机号是否可用，并发送验证码
    @Override
    public ServerResponse<String> getLoginPhoneCode(String phone) {
        ServerResponse  validResponse;
        if(StringUtil.isHandset(phone)){
            int count=userMapper.checkPhone(phone);
            if(count==1){
                //发送登录验证码
                validResponse=ServerResponse.createBySuccessMessage("验证码已发送");
                return validResponse;
            }
        }else{
            validResponse=ServerResponse.createByErrorMessage("参数错误");
            return validResponse;
        }
        return ServerResponse.createByErrorMessage("参数错误");
    }

    //检查手机号是否可用
    public ServerResponse<String>   checkPhoneValid(String phone){
        if(StringUtil.isHandset(phone)){
            int count=userMapper.checkPhone(phone);
            if(count>0){
                return ServerResponse.createByErrorMessage("手机号已经存在");
            }
        }else{
            return ServerResponse.createByErrorMessage("参数错误或手机号输入不正确");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<User> getLoginPhoneCode(User user) {
        int count=userMapper.insertUser(user);
        if(count>0){

        }
        return null;
    }
}
