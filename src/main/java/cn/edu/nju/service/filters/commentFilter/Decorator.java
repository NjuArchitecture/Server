package cn.edu.nju.service.filters.commentFilter;
import java.util.List;

import cn.edu.nju.service.filters.CommentInfo;
import cn.edu.nju.service.pipe.IFilter;

public class Decorator implements IFilter<CommentInfo>{
protected IFilter<CommentInfo> filter;
	
	public Decorator(){
		
	}
	public Decorator(IFilter<CommentInfo> ifilter){
		this.filter=ifilter;
	}
	
	@Override
	public List<CommentInfo> doFilter(List<CommentInfo> list) {
		// TODO Auto-generated method stub

		return filter.doFilter(list);

	}

}
