package com.yepu.controller;

import com.yepu.exception.BaseException;
import com.yepu.pojo.UpLoad;
import com.yepu.service.FileUploadService;
import com.yepu.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/upload")
public class FileUploadController extends BaseController {
    @Autowired
    private FileUploadService fileUploadService;

    /**
     * @方法名： uploadShaidanPhoto
     * @功能描述：上传多张资质图片
     * @param file
     */
    @RequestMapping(value="/uploadQualifications", method=RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ServerResponse<Object> uploadQualification(HttpServletRequest request,
            @RequestParam(value="file", required=true) MultipartFile[] file,UpLoad upLoad) throws BaseException {

        StringBuffer sb = new StringBuffer();
        UpLoad loadUser = new UpLoad();
        loadUser.setPhone(upLoad.getPhone());
        loadUser.setName(upLoad.getName());
        loadUser.setSex(upLoad.getSex());
        loadUser.setCard(upLoad.getCard());
        loadUser.setType(upLoad.getType());
        loadUser.setMsgPhone(upLoad.getMsgPhone());
        loadUser.setAddress(upLoad.getAddress());
        loadUser.setTitle(upLoad.getTitle());
        loadUser.setTitleMsg(upLoad.getTitleMsg());

        for(MultipartFile item :file){
            String filename = item.getOriginalFilename();
            // TODO 上传文件格式过滤
            String filePath = getFilePath("picture", filename);
//            String realPath = "/Users/Macx/Desktop/image/";  //自己电脑上新建目录写这类
            String realPath = "/root/service/images/";  //自己电脑上新建目录写这类
            File targetFile = new File(realPath + filePath);
            // 目录不存在时，要手动创建目录，该代码在当天首次上传图片时会执行
            File directory = targetFile.getParentFile();
            if (!directory.exists()) {
                directory.mkdirs();
            }
            if(item.getSize() > 0 ){
                try {
                    item.transferTo(targetFile); //转存文件到指定目录下
                    sb.append(filePath).append(",");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

            //根据phone name card查询用户是否唯一
            UpLoad obj = fileUploadService.queryByParam(loadUser);
            if(obj == null ){
                loadUser.setImg(sb.deleteCharAt(sb.length()-1).toString());
                loadUser.setUserId(upLoad.getUserId());
                if(fileUploadService.insert(loadUser) < 1){
                    throw new BaseException(1,"插入失败");
                }
            }else{
                loadUser.setImg(sb.deleteCharAt(sb.length()-1).toString());
                loadUser.setId(obj.getId());
                int num = fileUploadService.updateToImg(loadUser);
                if(num < 0){
                    throw new BaseException(1,"上传失败");
                }
            }

        return ServerResponse.createBySuccessMessage("上传成功");
    }
    
    

    private String getFilePath(String path, String filename) {
        return path + "/" + getDirname() + "/"  + filename;
    }

    private String getDirname() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
    
}
