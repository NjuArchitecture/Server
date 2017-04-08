package cn.edu.nju.dataservice;

import cn.edu.nju.utility.Comment;

import java.util.List;

/**
 * @author Qiang
 * @since 08/04/2017
 */
public interface CommentDataService {

    List<Comment> getCommentsByGoodsID(String goodId);


    List<Comment> getSomeForShow(int size);

    List<Comment> getSomeForShow();

    void empty();
}
