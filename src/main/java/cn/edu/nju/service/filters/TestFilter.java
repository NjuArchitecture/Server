import java.util.ArrayList;
import java.util.List;

import util.GoodInfo;
import util.IFilter;
import util.IPipe;
import goodsFilter.DateSortFilter;
import goodsFilter.Decorator;
import goodsFilter.SaleSortFilter;
import goodsFilter.SortFilter;
import goodsFilter.WebsiteSortFilter;


public class TestFilter {

	public static void main(String [] args){
		/**
		 * 自定义Filter，这里只为管道安装一个SortFilter
		 */
		IFilter<GoodInfo> f1=new SortFilter<GoodInfo>();
		//通过decorator的链式初始化来达到自由组合过滤条件的目的
		Decorator d1=new WebsiteSortFilter(new DateSortFilter(new SaleSortFilter(f1)));
		List<IFilter> list=new ArrayList<>();
		list.add(d1);
		
		/**
		 * 初始化管道
		 */
		IPipe pipe=new IPipe();
		
		/**
		 * 为管道安装过滤器
		 */
		pipe.registerFilter(list);
		
		/**
		 * 初始化待过滤数据
		 */
		List<GoodInfo> infoList=new ArrayList<>();
		GoodInfo gi1=new GoodInfo("http://123.com","淘宝","书包",324.0,"http://baidu.com","耐克官方旗舰店");
		GoodInfo gi2=new GoodInfo("http://456.com","京东","书包",314.0,"http://baidu.com","阿迪达斯官方旗舰店");
		infoList.add(gi1);
		infoList.add(gi2);
		
		/**
		 * 过滤
		 */
		pipe.doFilter(infoList);
		
	}
}
