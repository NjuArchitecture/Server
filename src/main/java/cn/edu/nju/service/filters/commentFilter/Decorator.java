package cn.edu.nju.service.filters.commentFilter;
import java.util.List;
import cn.edu.nju.service.pipe.IFilter;
public class Decorator implements IFilter<Comment>{
protected IFilter<Comment> filter;
	
	public Decorator(){
		
	}
	public Decorator(IFilter<Comment> ifilter){
		this.filter=ifilter;
	}
	
	@Override
	public List<Comment> doFilter(List<Comment> list) {
		// TODO Auto-generated method stub
		return filter.doFilter(list);

	}

}
