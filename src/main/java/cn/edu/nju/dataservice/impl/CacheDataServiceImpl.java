package cn.edu.nju.dataservice.impl;

import cn.edu.nju.dataservice.CacheDataService;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Akari on 2017/4/13.
 */

@Service
public class CacheDataServiceImpl implements CacheDataService {
    private Jedis jedis = null;

    public CacheDataServiceImpl() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JedisPool jedisPool = (JedisPool) context.getBean("jedisPool");
        jedis = jedisPool.getResource();
    }

    @Override
    public List<GoodInfo> search(String key) {
        key="*"+key+"*";
        Set<String> set = jedis.keys(key);

        List<GoodInfo> goodsList = new ArrayList<>();

        for (String s:set) {
            Map<String, String> maps = jedis.hgetAll(s);
            GoodInfo good = new GoodInfo();
            good.setTitle(maps.get("title"));
            good.setDescription(maps.get("description"));
            good.setPic1(maps.get("pic1"));
            good.setPic2(maps.get("pic2"));
            good.setPrice(Double.parseDouble(maps.get("price")));
            good.setSourceName(maps.get("sourceName"));
            good.setSourceURL(maps.get("sourceURL"));
            goodsList.add(good);
        }

        return goodsList;
    }
}
