package cn.edu.nju.dataservice;

import cn.edu.nju.utility.GoodInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class RedisDataServiceTest {
    ApplicationContext context = null;
    JedisPool jedisPool = null;
    Jedis jedis = null;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jedisPool = (JedisPool) context.getBean("jedisPool");
        jedis = jedisPool.getResource();
    }

    /**
     * spring集成之后使用redis连接池
     */
    @Test
    public void testJedis() {
        String key="*4G*";
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

        for(GoodInfo good:goodsList){
            System.out.println(good.getTitle());
        }
    }

    //    @Test
    public void testHash(){
        JedisPool jedisPool = (JedisPool) context.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();

        String key = "goods";

        // hset 仅当操作在hash中创建新field时返回1
        Long hset = jedis.hset(key, "id", "1");
        print("hset id 1=" + hset + "; value=" + jedis.hget(key, "id"));

        // 如果field已存在则执行修改,并返回0
        hset = jedis.hset(key, "id", "2");
        print("hset id 2=" + hset + "; value=" + jedis.hget(key, "id"));

        // hexists 判断field是否存在
        boolean hexists = jedis.hexists(key, "id");
        print("hexists id=" + hexists);
        hexists = jedis.hexists(key, "title");
        print("hexists title=" + hexists);

        // hsetex 如果field不存在则添加, 已存在则不会修改值, 可用来添加要求不重复的field
        Long hsetnx = jedis.hsetnx(key, "id", "3");
        print("hsetnx id 3=" + hsetnx + "; value=" + jedis.hget(key, "id"));
        hsetnx = jedis.hsetnx(key, "title", "商品001");
        print("hsetnx title 商品001=" + hsetnx + "; value=" + jedis.hget(key, "title"));

        // hmset 设置多个field
        Map<String, String> msets = new HashMap<>();
        msets.put("color", "red");
        msets.put("width", "100");
        msets.put("height", "80");
        String hmset = jedis.hmset(key, msets);
        print("hmset color,width,height=" + hmset);

        // hincr 新增整数类型的键值对或增加值
        long hincr = jedis.hincrBy(key, "price", 4L);
        print("hincrBy price 4=" + hincr + "; value=" + jedis.hget(key, "price"));

        // hlen 读取field数量
        print("hlen=" + jedis.hlen(key));

        // hkeys 读取所有field
        Set<String> sets = jedis.hkeys(key);
        print("hkeys=" + Arrays.toString(sets.toArray()));

        // hvals 读取所有值
        List<String> list = jedis.hvals(key);
        print("hvals=" + Arrays.toString(list.toArray()));

        // hgetAll 读取所有键值对
        System.out.println("hgetAll 读取所有键值对");
        Map<String, String> maps = jedis.hgetAll(key);
        for (String field : maps.keySet()) {
            System.out.println("hget " + field + "=" + maps.get(field));
        }
        System.out.println("------------------------------------------------------");
        System.out.println();

        // hdel 删除field
        Long hdel = jedis.hdel(key, "id");
        print("hdel id=" + hdel);

        // 删除多个field
        hdel = jedis.hdel(key, "color", "width", "height");
        print("hdel color,width,height=" + hdel);

        // hincrBy 在整数类型值上增加, 返回修改后的值
        Long hincrBy = jedis.hincrBy(key, "price", 100l);
        print("hincrBy price 100=" + hincrBy);

        // hget 读取单个field的值
        String hget = jedis.hget(key, "title");
        print("hget title=" + hget);

        // hmget 批量读取field的值
        jedis.hmget(key, "title", "price");
        list = jedis.hvals(key);
        print("hmget title,price=" + Arrays.toString(list.toArray()));

        jedis.close();
    }

    private void addGoods(GoodInfo good,int i) {
        Map<String, String> map = new HashMap<>();
        map.put("title", good.getTitle());
        map.put("description", good.getDescription());
        map.put("pic1", good.getPic1());
        map.put("pic2", good.getPic2());
        map.put("price", String.valueOf(good.getPrice()));
        map.put("sourceName", good.getSourceName());
        map.put("sourceURL", good.getSourceURL());

        String key = "id:"+i+"-title:" + good.getTitle();
        System.out.println(jedis.hmset(key, map));
    }

    private static void print(String info) {
        System.out.println(info);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

}
