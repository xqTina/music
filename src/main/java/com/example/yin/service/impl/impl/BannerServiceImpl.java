package com.example.yin.service.impl.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yin.mapper.BannerMapper;
import com.example.yin.model.domin.Banner;
import com.example.yin.service.impl.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/*定义了一个名为BannerServiceImpl的类，它继承自MyBatis Plus的ServiceImpl类，并实现了BannerService接口。
ServiceImpl是一个泛型类，需要指定两个类型参数：一个是Mapper接口（BannerMapper），另一个是实体类（Banner）。
selectLis是ServiceImpl的方法
*/
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner>
        implements BannerService {

    @Autowired
   private  BannerMapper bannerMapper;
    @Cacheable(value = "banner", key = "'list'")  //放在缓存中 redis 是以key-value进行存储的
    @Override
    public List<Banner> getAllBanner() {
        System.out.println("没有走缓存");
        return bannerMapper.selectList(null);
    }


}
