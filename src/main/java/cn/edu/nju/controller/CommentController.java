package cn.edu.nju.controller;

import cn.edu.nju.service.CommentService;
import cn.edu.nju.utility.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sbin on 2017/4/8.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    public List<Comment> getComment(@RequestParam String goodId){

        if(StringUtils.isEmpty(goodId)){
            return Arrays.asList(new Comment("快递很快卖家服务态度很好手机很好看，还送了很多东西太好了。", "2017-04-10 09:09" , "呦***1", "1231231231123"),
                    new Comment("全五星，买到小米最满意的手机，很漂亮， 很顺畅。", "2017-03-14 09:21" , "jd_151669kpu", "1231231231123"),
                    new Comment("给朋友买的自己用动物5s，感觉还不错，不过自家处理器还没正在试用，哈哈，到时候追加！！！", "2017-03-09 13:58" , " 鹿***_", "1231231231123"),
                    new Comment("小米手机中颜值最高的，商家当天发货，物流给力，主要是手机确实轻薄漂亮，赞赞赞", "2017-03-14 10:30" , "结***好", "1231231231123"));
        }
        return commentService.getGoodComment(goodId);
    }

}
