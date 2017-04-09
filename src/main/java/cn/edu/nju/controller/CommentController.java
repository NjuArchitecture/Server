package cn.edu.nju.controller;

import cn.edu.nju.service.CommentService;
import cn.edu.nju.utility.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
            return new ArrayList<>();
        }
        return commentService.getGoodComment(goodId);
    }

}
