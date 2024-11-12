package com.example.yin.controller;


import com.example.yin.model.request.CollectRequest;
import com.example.yin.service.impl.CollectService;
import com.example.yin.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;
    @PostMapping("/collection/add")
    public R addCollection(@RequestBody CollectRequest addCollectRequest) {
        return collectService.addCollection(addCollectRequest);
    }

    //TODO  这些其实有点偏简单的逻辑  所以就一点 所以放在外面  拿到里面
    // 取消收藏的歌曲
    @DeleteMapping("/collection/delete")
    public R deleteCollection(@RequestParam Integer userId, @RequestParam Integer songId) {
        return collectService.deleteCollect(userId, songId);
    }

    // 是否收藏歌曲
    @PostMapping("/collection/status")
    public R isCollection(@RequestBody CollectRequest isCollectRequest) {
        return collectService.existSongId(isCollectRequest);

    }

    // 返回的指定用户 ID 收藏的列表
    @GetMapping("/collection/detail")
    public R collectionOfUser(@RequestParam Integer userId) {
        return collectService.collectionOfUser(userId);
    }
/*
    // 提交收藏
    @PostMapping("/collect/add")
     public Object addCollect(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId");
        String type = request.getParameter("type");
        String songId = request.getParameter("songId");
        if (songId == null || songId.equals("")) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "收藏歌曲为空");
            return jsonObject;
        }
        if (collectService.existSongId(Integer.parseInt(userId), Integer.parseInt(songId))) {
            jsonObject.put(Consts.CODE, 2);
            jsonObject.put(Consts.MSG, "已收藏");
            return jsonObject;
        }
        //保存到收藏对象中
        Collect collect = new Collect();
        collect.setUserId(Integer.parseInt(songId));
        collect.setType(new Byte(type));
        collect.setSongId(Integer.parseInt(songId));
        Boolean flag = collectService.insert(collect);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "收藏成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"收藏失败");
        return jsonObject;

    }*/

  /*  @RequestMapping(value = "/collect/delete",method = RequestMethod.GET)
    public Object deleteCollect(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = collectService.delete(Integer.parseInt(id));
        return flag;
    }
    @GetMapping("/collect/allCollect")
    public Object allCollect(HttpServletRequest request){
        return collectService.allCollect();
    }
    *//*查询某个用户下的收藏列表*//*
    @GetMapping("/collect/collectOfUserId")
    public Object collectOfUserId(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return collectService.collectOfUserId(Integer.parseInt(userId));

    }*/

}
