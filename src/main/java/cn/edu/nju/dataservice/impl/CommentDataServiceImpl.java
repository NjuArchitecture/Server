package cn.edu.nju.dataservice.impl;

import cn.edu.nju.dataservice.CommentDataService;
import cn.edu.nju.dataservice.dao.CommentRepository;
import cn.edu.nju.utility.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiang
 * @since 08/04/2017
 */
@Service
public class CommentDataServiceImpl implements CommentDataService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentDataServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public List<Comment> getCommentsByGoodsID(String goodId) {
        return commentRepository.getCommentsByGoodsID(goodId);
    }

    @Override
    public List<Comment> getSomeForShow(int size) {
        int index = 0;
        List<Comment> result = new ArrayList<>(size);
        for (Comment comment : commentRepository.findAll()) {
            result.add(comment);
            index++;
            if (index >= size) {
                break;
            }
        }

        return result;
    }

    @Override
    public List<Comment> getSomeForShow() {
        return getSomeForShow(10);
    }

    @Override
    public void persist(List<Comment> comments) {
        commentRepository.save(comments);
    }

    @Override
    public void empty() {
        commentRepository.deleteAll();
    }
}
