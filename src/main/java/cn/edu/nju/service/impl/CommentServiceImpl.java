package cn.edu.nju.service.impl;

import cn.edu.nju.service.CommentService;
import cn.edu.nju.utility.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sbin on 2017/4/8.
 */
@Component
public class CommentServiceImpl implements CommentService {

    @Override
    public List<Comment> getGoodComment(String goodId) {
        return null;
    }

}
