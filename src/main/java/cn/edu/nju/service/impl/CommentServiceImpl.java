package cn.edu.nju.service.impl;

import cn.edu.nju.dataservice.CommentDataService;
import cn.edu.nju.service.CommentService;
import cn.edu.nju.utility.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author sbin
 * @since 2017/4/8
 */
@Component
public class CommentServiceImpl implements CommentService {
    private final
    CommentDataService commentDataService;

    @Autowired
    public CommentServiceImpl(CommentDataService commentDataService) {
        this.commentDataService = commentDataService;
    }

    @Override
    public List<Comment> getGoodComment(String goodId) {
        return commentDataService.getCommentsByGoodsID(goodId);
    }

}
