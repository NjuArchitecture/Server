package cn.edu.nju.service.filters.commentFilter;
import java.util.List;

import cn.edu.nju.service.filters.CommentInfo;
import cn.edu.nju.service.pipe.IFilter;

public class Decorator<T extends CommentInfo> implements IFilter<T> {
protected IFilter<T> filter;
	
	public Decorator(){
		
	}
	public Decorator(IFilter<T> ifilter){
		this.filter=ifilter;
	}
	
	@Override
	public List<T> doFilter(List<T> list) {
		// TODO Auto-generated method stub

		return filter.doFilter(list);

	}

}
