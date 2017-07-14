package com.yepu.controller;

import com.yepu.p_do.HomeCount;
import com.yepu.service.IHomeService;
import com.yepu.vo.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home/")
public class HomeController {

    private IHomeService homeService;

    @RequestMapping(value = "home_main",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<HomeCount> getLoginPhoneCode() {
        ServerResponse<HomeCount > response = homeService.getHomeMain();
        return response;
    }
}
