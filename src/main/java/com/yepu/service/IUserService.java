package com.yepu.service;

import com.yepu.pojo.User;
import com.yepu.vo.ServerResponse;

public interface IUserService {

    ServerResponse<String> getRegisterPhoneCode(String phone);

    ServerResponse<String> getLoginPhoneCode(String phone);

    ServerResponse<User> getLoginPhoneCode(User user);
}
