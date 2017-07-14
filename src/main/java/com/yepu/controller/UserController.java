package com.yepu.controller;

import com.yepu.p_do.Register;
import com.yepu.pojo.User;
import com.yepu.service.ICodeService;
import com.yepu.service.IUserService;
import com.yepu.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService userService;

    private ICodeService codeService;

    /**
     * 注册检查手机号是否存在，若不存在，则发送验证码
     * @param user
     * @return
     */
    @RequestMapping(value = "register_code",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> getRegisterPhoneCode(@RequestBody User user) {
        ServerResponse<String > response = userService.getRegisterPhoneCode(user.getPhone());
        return response;
    }

    /**
     *登录检查手机号是否存在，若不存在，则发送验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "login_code",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> getLoginPhoneCode(String phone) {
        ServerResponse<String > response = userService.getLoginPhoneCode(phone);
        return response;
    }



    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertuserByInfo(@RequestBody Register register) {
      //  ServerResponse<String > response = userService.getRegisterPhoneCode(user.getPhone());
        return ServerResponse.createBySuccess("chenggg");
    }


}
