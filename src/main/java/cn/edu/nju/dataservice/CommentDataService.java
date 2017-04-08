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
    //注意要传入 商品的id， id可以先用 searchDataService 的 getAll 方法，然后再插数据
    void persist(List<Comment> comments);

    void empty();
}
