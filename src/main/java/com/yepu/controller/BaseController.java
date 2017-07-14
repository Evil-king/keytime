package com.yepu.controller;

import com.yepu.util.MD5;
import com.yepu.util.SessionIdCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    public static void setUserId(HttpServletRequest request, HttpServletResponse response, Integer userId) {
        String requestType = request.getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(requestType);
        if (isAjax) {
            // PC端存入cookie
        } else {
            // 移动端存入Header
            String token = MD5.encryptMD5(userId.toString());
            SessionIdCache.setValue(token, userId);
            response.addHeader("token", token);
        }
    }
}