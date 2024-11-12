package com.example.yin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.model.domin.Collect;
import com.example.yin.model.request.CollectRequest;
import org.apache.ibatis.annotations.Param;
import com.example.yin.common.R;
import java.util.List;

public interface CollectService extends IService<Collect> {
    R addCollection(CollectRequest addCollectRequest);

    R existSongId(CollectRequest isCollectRequest);

    R deleteCollect(Integer userId,Integer songId);

    R collectionOfUser(Integer userId);
}
