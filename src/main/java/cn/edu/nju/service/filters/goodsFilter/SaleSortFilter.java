package cn.edu.nju.service.filters.goodsFilter;

import java.util.List;

import cn.edu.nju.service.filters.GoodInfo;
import cn.edu.nju.service.pipe.IFilter;
/**
 * Created by hmy on 2017/3/12.
 */
public class SaleSortFilter extends Decorator<GoodInfo>{
	/**
	 * 规则3:根据商品的销售量排名
	 * @param ifilter
	 */
	public SaleSortFilter(IFilter<GoodInfo> ifilter){
		super(ifilter);
		}
	
	public List<GoodInfo> doFilter(List<GoodInfo> list) {

		// TODO Auto-generated method stub
		return sortBySaleRank(filter.doFilter(list));
	}
	
	public List<GoodInfo> sortBySaleRank(List<GoodInfo> list){
		System.out.println("sort by sales rank");
		return list;
	}
	
	
}
