package goodsFilter;

import java.util.List;

import util.IFilter;

public class Decorator<GoodInfo> implements IFilter<GoodInfo> {
	protected IFilter<GoodInfo> filter;
	
	public Decorator(){
		
	}
	
	public Decorator(IFilter<GoodInfo> ifilter){
		this.filter=ifilter;
	}
	
	@Override
	public List<GoodInfo> doFilter(List<GoodInfo> list) {
		// TODO Auto-generated method stub
		return filter.doFilter(list);
	}
}