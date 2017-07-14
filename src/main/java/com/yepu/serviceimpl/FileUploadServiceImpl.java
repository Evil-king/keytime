package com.yepu.serviceimpl;

import com.yepu.dao.UpLoadMapper;
import com.yepu.pojo.UpLoad;
import com.yepu.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件操作服务实现类
 * Created by Fox on 2017/5/29.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService{
    @Autowired
    private UpLoadMapper loadMapper;

    public int updateToImg(UpLoad loadUser) {
        return loadMapper.updateById(loadUser);
    }

    //查询对象信息
    public UpLoad queryByUserId(Integer userid) {

        return loadMapper.queryByUserId(userid);
    }

    public int insert(UpLoad loadUser) {
        return loadMapper.insert(loadUser);
    }

    //根据phone name card查询用户是否唯一
    public UpLoad queryByParam(UpLoad upLoad) {
        return loadMapper.selectByParam(upLoad);
    }

}
