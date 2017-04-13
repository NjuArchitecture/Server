package cn.edu.nju.service.impl;

import cn.edu.nju.dataservice.CacheDataService;
import cn.edu.nju.service.CacheService;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Akari on 2017/4/13.
 */
@Service
public class CacheServiceImpl implements CacheService {

    private final
    CacheDataService cacheDataService;

    @Autowired
    public CacheServiceImpl(CacheDataService cacheDataService) {
        this.cacheDataService = cacheDataService;
    }


    @Override
    public List<GoodInfo> search(String key) {
        return cacheDataService.search(key);
    }
}
