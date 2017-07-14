package com.yepu.service;

import com.yepu.p_do.HomeCount;
import com.yepu.vo.ServerResponse;

public interface IHomeService {
     ServerResponse<HomeCount> getHomeMain();
}
