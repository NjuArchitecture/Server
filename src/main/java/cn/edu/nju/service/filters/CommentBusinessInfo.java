package cn.edu.nju.service.filters;

import java.util.ArrayList;

/**
 * Created by fwtgm on 2017/4/11.
 */
public class CommentBusinessInfo {
    private CommentInfo commentInfo;
    private ArrayList<String> businessWords;

    public CommentInfo getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(CommentInfo commentInfo) {
        this.commentInfo = commentInfo;
    }

    public ArrayList<String> getBusinessWords() {
        return businessWords;
    }

    public void setBusinessWords(ArrayList<String> businessWords) {
        this.businessWords = businessWords;
    }
}
