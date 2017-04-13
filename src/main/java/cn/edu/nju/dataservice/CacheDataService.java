package cn.edu.nju.dataservice;

import cn.edu.nju.utility.GoodInfo;

import java.util.List;

/**
 * Created by Akari on 2017/4/13.
 */
public interface CacheDataService {
    /**
     * 搜索
     * @param key 可以用空格隔开多个关键字，为模糊搜索
     * @return
     */
    List<GoodInfo> search(String key);

}
