package cn.edu.nju.dataservice;

import cn.edu.nju.utility.GoodInfo;

import java.util.List;

/**
 * @author Qiang
 * @since 08/04/2017
 */
public interface SearchDataService {
    /**
     * 搜索
     * @param key 可以用空格隔开多个关键字，为模糊搜索
     * @return
     */
    List<GoodInfo> search(String key);

    /**
     * 存储商品信息
     * @param goods
     */
    void persist(List<GoodInfo> goods);

    /**
     * 仅在标题中搜索
     * @param key 可以用空格隔开多个关键字，为模糊搜索
     * @return
     */
    List<GoodInfo> searchInTitle(String key);

    /**
     * 仅在描述中搜索
     * @param key 可以用空格隔开多个关键字，为模糊搜索
     * @return
     */
    List<GoodInfo> searchInDescription(String key);

    List<GoodInfo> findAll();

    //Only for test!!!!
    void empty();

}
