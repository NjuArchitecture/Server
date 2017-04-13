package cn.edu.nju.service;

import cn.edu.nju.utility.GoodInfo;

import java.util.List;

/**
 * Created by Akari on 2017/4/13.
 */
public interface CacheService {
    List<GoodInfo> search(String key);
}
