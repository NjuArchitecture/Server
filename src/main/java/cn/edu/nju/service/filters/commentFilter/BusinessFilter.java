package cn.edu.nju.service.filters.commentFilter;
import cn.edu.nju.service.filters.BusinessWords;
import cn.edu.nju.service.filters.CommentInfo;
import cn.edu.nju.service.pipe.IFilter;

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
        System.out.println("sort by business words");
        return list;
    }
    public static boolean containsBusinessWord(CommentInfo c){
        String content=c.getContent();
        boolean isBusiness=false;
        int len=businessWords.length;
        for(int i=0;i<len;i++){
            if(content.contains(businessWords[i])){
                isBusiness=true;
                break;
            }
        }
        return isBusiness;
    }
    public static void notifyBusiness(){


    }

}
