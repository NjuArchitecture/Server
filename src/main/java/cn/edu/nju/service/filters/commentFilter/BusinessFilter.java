package cn.edu.nju.service.filters.commentFilter;

import cn.edu.nju.service.filters.BusinessWords;
import cn.edu.nju.service.filters.CommentBusinessInfo;
import cn.edu.nju.service.filters.CommentInfo;
import cn.edu.nju.service.pipe.IFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fwtgm on 2017/4/11.
 */
public class BusinessFilter extends Decorator<CommentInfo>{
    static BusinessWords s=new BusinessWords();
    public static String[] businessWords=s.getBusinessWords();


    public BusinessFilter(IFilter ifilter){
        super(ifilter);
    }
    public List<CommentInfo> doFilter(List<CommentInfo> list) {
        // TODO Auto-generated method stub
        return sortByBusinessWords(filter.doFilter(list));
    }
    public List<CommentInfo> sortByBusinessWords(List<CommentInfo> list){
        List<CommentBusinessInfo> cblist=new ArrayList<CommentBusinessInfo>();
        for(CommentInfo c:list){
            CommentBusinessInfo commentBusinessInfo=new CommentBusinessInfo();
            ArrayList<String>businessName=findBusinessWord(c);
            if(businessName.size()>0){
                commentBusinessInfo.setBusinessWords(businessName);
                commentBusinessInfo.setCommentInfo(c);
                cblist.add(commentBusinessInfo);
            }
        }

        System.out.println("sort by business words");
        if(cblist.size()>0){
            for(CommentBusinessInfo cb:cblist){
                notifyBusiness(cb);
            }
        }

        return list;
    }
    public static ArrayList<String> findBusinessWord(CommentInfo c){
        ArrayList<String>array=new ArrayList<String>();
        String content=c.getContent();
        int len=businessWords.length;
        for(int i=0;i<len;i++){
            if(content.contains(businessWords[i])){
                array.add(businessWords[i]);
            }
        }
        return array;
    }
    public static void notifyBusiness(CommentBusinessInfo cb){
        ArrayList<String> business=cb.getBusinessWords();
        CommentInfo ci=cb.getCommentInfo();
        for(String s:business){
            System.out.println("id"+ci.getId()+"business:"+s);
        }

    }

}
