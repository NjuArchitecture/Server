package cn.edu.nju.dataservice;

import cn.edu.nju.utility.GoodInfo;

import java.util.List;

/**
 * @author Qiang
 * @since 08/04/2017
 */
public interface SearchDataService {

    List<GoodInfo> search(String key);

    void persist(List<GoodInfo> goods);

    List<GoodInfo> searchInTitle(String key);

    List<GoodInfo> searchInDescription(String key);

    List<GoodInfo> searchWithMultiKeyWords(String field, List<String> keys);

    List<GoodInfo> searchWithMultiKeyWords(List<String> keys);
    //Only for test!!!!
    void empty();

}
