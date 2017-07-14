package com.yepu.serviceimpl;

import com.yepu.common.SmsMsg;
import com.yepu.dao.CodeMapper;
import com.yepu.exception.BaseException;
import com.yepu.pojo.Code;
import com.yepu.service.ICodeService;
import com.yepu.util.MD5;
import com.yepu.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Service("iCodeService")
public class CodeServiceImpl implements ICodeService{
    @Autowired
    private CodeMapper codeMapper;
    public  void sendSms(String mobiles, String content,Integer type) throws BaseException {
        sendSms(mobiles, content, SmsMsg.PS_CODE, 0,type);
    }

    public void sendSms(String mobiles, String content, long task_id,Integer type) throws BaseException {
        sendSms(mobiles, content, SmsMsg.PS_CODE, task_id,type);

    }

    public void sendSms(String mobiles, String content, String sp_code,Integer type) throws BaseException {
        sendSms(mobiles, content, SmsMsg.PS_CODE, 0,type);
    }

    public void sendSms(String mobiles, String content, String sp_code,
                        long task_id,Integer type) throws BaseException {
        try {
            String urlencContent = URLEncoder.encode(content,"utf-8");
            String sign= MD5.sign(urlencContent, SmsMsg.PWD, "utf-8");
            String postData = "content=" + urlencContent + "&destMobiles="
                    + mobiles + "&sign=" + sign + "&cust_code=" + SmsMsg.CUST_CODE
                    + "&sp_code=" + SmsMsg.PS_CODE + "&task_id=" + task_id;
            URL myurl = new URL(SmsMsg.SMSURL);
            URLConnection urlc = myurl.openConnection();
            urlc.setReadTimeout(1000 * 30);
            urlc.setDoOutput(true);
            urlc.setDoInput(true);
            urlc.setAllowUserInteraction(false);

            DataOutputStream server = new DataOutputStream(urlc.getOutputStream());

            server.write(postData.getBytes("utf-8"));
            server.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlc.getInputStream(), "utf-8"));
            String resXml = "", s = "";
            while ((s = in.readLine()) != null)
                resXml = resXml + s + "\r\n";
            in.close();
            saveSms(mobiles,content,postData,resXml,type);
        } catch (Exception e) {
            throw new BaseException("调用验证码错误");
        }
    }


    //保存短信到数据库
    public void saveSms(String phone,String content,String postData,String resXml,int type){
        int count=codeMapper.getCodeByPhoneAndType(phone,type);
        Code code=new Code();
        code.setPhone(phone);
        code.setContent(content);
        code.setPostData(postData);
        code.setResXml(resXml);
        if(count==0){
            code.setType(String.valueOf(type));
            count=codeMapper.insertCode(code);
            if(count>0){
                System.out.println("数据更新成功");
            }
        }else{
            count=codeMapper.updateByPhoneAndType(code);
            if(count>0){
                System.out.println("数据更新成功");
            }
        }
    }


    @Override
    public ServerResponse<Code> sendCodebyType(String phone, int type) {
        return ServerResponse.createBySuccess("数据更新成功");
    }
}
