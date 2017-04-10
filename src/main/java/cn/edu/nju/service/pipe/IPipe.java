package cn.edu.nju.service.pipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yui on 2017/2/21.
 */
public class IPipe<T> {

    public List<IFilter<T>> filters;

    public void registerFilter(List<IFilter<T>> filter){
    	filters=new ArrayList<>();
        for(IFilter<T> ifilter : filter) {
            filters.add(ifilter);
        }
    }

    public  List<T> doFilter(List<T> list){
    	List<T> result=new ArrayList<>();
    	
    	 for(IFilter<T> ifilter : filters) {
            result=ifilter.doFilter(list);
         }
    	 
        return list;
    }
}