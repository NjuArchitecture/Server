package goodsFilter;

import java.util.List;

import util.IFilter;
/**
 * Created by hmy on 2017/3/12.
 */

public class WebsiteSortFilter<GoodInfo> extends Decorator<GoodInfo>{
	/**
	 * 规则1:根据合作网站赞助费的高低来排名
	 * @param ifilter
	 */
	public WebsiteSortFilter(IFilter ifilter){
		super(ifilter);
		}
	
	public List<GoodInfo> doFilter(List<GoodInfo> list) {
		// TODO Auto-generated method stub
		return sortByWebsiteRank(filter.doFilter(list));
	}
	
	public List<GoodInfo> sortByWebsiteRank(List<GoodInfo> list){
		System.out.println("sort by website rank");
		return list;
	}
	
	
}
