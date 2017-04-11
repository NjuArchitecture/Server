package cn.edu.nju.service.filters.commentFilter;

import cn.edu.nju.service.filters.CommentInfo;
import cn.edu.nju.service.filters.FrequencyWords;
import cn.edu.nju.service.pipe.IFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fwtgm on 2017/4/11.
 */
public class WordFrequencyFilter extends Decorator<CommentInfo>{

    final static int MaxAppearance=10;
    static FrequencyWords s=new FrequencyWords();
    public static String[] frequencyWords=s.getFrequencyWords();

    public WordFrequencyFilter(IFilter ifilter){
        super(ifilter);
    }

    public List<CommentInfo> doFilter(List<CommentInfo> list) {
        List<CommentInfo>result=new ArrayList<CommentInfo>();
        for(CommentInfo c:list){
            if(isValid(c)==true){
                result.add(c);
            }else{
                notifyAdmin(c);
            }
        }

        return result;
    }
/*
    统计词汇表中单词出现次数
 */
    public static boolean isValid(CommentInfo c){
        int len=frequencyWords.length;
        int [] appearCount=new int[len];
        boolean isValid=true;
        String content=c.getContent();

        for(int i=0;i<len;i++){
            appearCount[i]=countAppear(content,frequencyWords[i]);
        }
        int maxAppear=maxNum(appearCount);
        if(maxAppear>MaxAppearance){
            isValid=false;
        }
        return isValid;
    }
/*
    使用split方法统计文本中单词出现的个数
 */
    public static int countAppear(String content,String word){
        String []temp=content.split(word);
        int count=temp.length-1;
        return count;
    }

    public static int maxNum(int[]array){
        int max=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }

    public static void notifyAdmin(CommentInfo c){
        System.out.print("frequency:"+c.getId());
    }

}
