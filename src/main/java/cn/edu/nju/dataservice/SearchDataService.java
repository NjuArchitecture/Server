package cn.edu.nju.dataservice;

import cn.edu.nju.utility.GoodInfo;

import java.util.List;

/**
 * @author Qiang
 * @since 07/04/2017
 */
public interface SearchDataService {

    List<GoodInfo> searchGoodInfo(String key);

    void persist(List<GoodInfo> goods);



}
