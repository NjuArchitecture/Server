package cn.edu.nju.service.dataInit;

import cn.edu.nju.utility.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbin on 2017/4/8.
 */
public class CommentDataCreator {

    public List<Comment> create(String goodId){

        String[] strings = {""};

        List<Comment> comments = new ArrayList<>();
        for(int i=0;i<10;i++){
            Comment comment = new Comment();
            comment.setId(goodId+"_c"+i);
//            comment.setContent();
        }
        return null;
    }

}
