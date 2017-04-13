package cn.edu.nju.dataservice.impl;

import cn.edu.nju.dataservice.CacheDataService;
import cn.edu.nju.dataservice.dao.CacheDataRepository;
import cn.edu.nju.dataservice.dao.CommentRepository;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Akari on 2017/4/13.
 */

@Service
public class CacheDataServiceImpl implements CacheDataService {

    private final CacheDataRepository cacheDataRepository;

    @Autowired
    public CacheDataServiceImpl(CacheDataRepository cacheDataRepository) {
        this.cacheDataRepository = cacheDataRepository;
    }

    @Override
    public List<GoodInfo> search(String key) {
        return cacheDataRepository.search(key);
    }
}
