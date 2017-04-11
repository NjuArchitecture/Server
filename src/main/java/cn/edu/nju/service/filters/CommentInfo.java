package cn.edu.nju.service.filters;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Qiang
 * @since 11/04/2017
 */
public class CommentInfo {

    private String id;

    private String content;
    private String time;
    private String userName;
    private String goodsID;


    public CommentInfo(String content, String time, String userName, String goodsID) {
        this.content = content;
        this.time = time;
        this.userName = userName;
        this.goodsID = goodsID;
    }

    public CommentInfo() {
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
