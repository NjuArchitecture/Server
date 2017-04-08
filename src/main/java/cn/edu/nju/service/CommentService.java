package cn.edu.nju.service;

import cn.edu.nju.utility.Comment;

import java.util.List;

/**
 * Created by sbin on 2017/4/8.
 */
public interface CommentService {

    List<Comment> getGoodComment(String goodId);

}
