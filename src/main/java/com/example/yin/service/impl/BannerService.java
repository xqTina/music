package com.example.yin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.model.domin.Banner;

import java.util.List;

public interface BannerService extends IService<Banner> {

    List<Banner> getAllBanner();

}
