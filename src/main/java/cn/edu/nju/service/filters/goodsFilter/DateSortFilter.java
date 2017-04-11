package cn.edu.nju.service.filters.goodsFilter;

import java.util.List;

import cn.edu.nju.service.filters.GoodInfo;
import cn.edu.nju.service.pipe.IFilter;
/**
 * Created by hmy on 2017/3/12.
 */

public class DateSortFilter extends Decorator<GoodInfo>{
	/**
	 * 规则2:根据商品发布时间来进行排名
	 * @param ifilter
	 */
	public DateSortFilter(IFilter ifilter){
		super(ifilter);
		}
	
	public List<GoodInfo> doFilter(List<GoodInfo> list) {
		// TODO Auto-generated method stub
		return sortByDateRank(filter.doFilter(list));
	}
	
	public List<GoodInfo> sortByDateRank(List<GoodInfo> list){
		System.out.println("sort by date rank");
		return list;
	}
	
	
}
