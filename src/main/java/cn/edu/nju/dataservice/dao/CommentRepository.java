package cn.edu.nju.dataservice.dao;

import cn.edu.nju.utility.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 08/04/2017
 */
public interface CommentRepository extends ElasticsearchRepository<Comment, String> {

   List<Comment> getCommentsByGoodsID(String goodId);

}
