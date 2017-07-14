package com.yepu.service;

import com.yepu.pojo.UpLoad;

/**
 * 文件操作服务
 * Created by Fox on 2017/5/29.
 */
public interface FileUploadService {

    int updateToImg(UpLoad load);

    UpLoad queryByUserId(Integer userid);

    int insert(UpLoad loadUser);

    UpLoad queryByParam(UpLoad loadUser);
}
