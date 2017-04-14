package cn.edu.nju.dataservice.dao;

import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Akari on 2017/4/13.
 */
@Repository
public class CacheDataRepository {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<GoodInfo> search(String key) {
        key="*"+key+"*";
        Set<String> set = stringRedisTemplate.keys(key);

        List<GoodInfo> goodsList = new ArrayList<>();

        for (String s:set) {
            Map<Object, Object> maps = stringRedisTemplate.opsForHash().entries(s);
            GoodInfo good = new GoodInfo();
            good.setId((String) maps.get("id"));
            good.setTitle((String) maps.get("title"));
            good.setDescription((String) maps.get("description"));
            good.setPic1((String) maps.get("pic1"));
            good.setPic2((String) maps.get("pic2"));
            good.setPrice(Double.parseDouble((String) maps.get("price")));
            good.setSourceName((String) maps.get("sourceName"));
            good.setSourceURL((String) maps.get("sourceURL"));
            goodsList.add(good);
        }

        return goodsList;
    }

}
