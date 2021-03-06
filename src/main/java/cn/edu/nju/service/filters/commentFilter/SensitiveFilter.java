package cn.edu.nju.service.filters.commentFilter;

import cn.edu.nju.service.filters.CommentInfo;
import cn.edu.nju.service.filters.SensitiveWords;
import cn.edu.nju.service.pipe.IFilter;

import java.util.ArrayList;
import java.util.List;


public class SensitiveFilter implements IFilter<CommentInfo> {
	static SensitiveWords s=new SensitiveWords();
	public static String[] sensitiveWords=s.getSensitiveWords();

	@Override
	public List<CommentInfo> doFilter(List<CommentInfo> list) {
		List<CommentInfo>result_comment=new ArrayList<CommentInfo>();
		for(CommentInfo c:list){
			if(isSensitive(c)==false){
				result_comment.add(c);
			}else{
				notifyAdmin(c);

			}

		}
		return result_comment;

	}


	public static boolean isSensitive(CommentInfo c){
		String content=c.getContent();
		boolean sensitive=false;
		int len=sensitiveWords.length;
		for(int i=0;i<len;i++){
			if(content.contains(sensitiveWords[i])){
				sensitive=true;
				break;
			}
		}
		return sensitive;
	}

	public static void notifyAdmin(CommentInfo c){
		System.out.print("sensitive:"+c.getId());
	}

}
