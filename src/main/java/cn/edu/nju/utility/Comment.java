package cn.edu.nju.utility;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Qiang
 * @since 08/04/2017
 */
@Document(indexName = "comment", type = "comment", shards = 5, replicas = 1, refreshInterval = "-1")
public class Comment {
    @Id
    private String id;

    private String content;
    private String time;
    private String userName;
    private String goodsID;


    public Comment(String content, String time, String userName, String goodsID) {
        this.content = content;
        this.time = time;
        this.userName = userName;
        this.goodsID = goodsID;
    }

    public Comment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
