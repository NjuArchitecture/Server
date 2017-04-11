package cn.edu.nju.service.filters.goodsFilter;

import java.util.List;

import cn.edu.nju.service.filters.GoodInfo;
import cn.edu.nju.service.pipe.IFilter;

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
