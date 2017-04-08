package cn.edu.nju.service;

import cn.edu.nju.utility.GoodInfo;

import java.util.List;

/**
 * @author Qiang
 * @since 07/04/2017
 */
public interface SearchService {

    List<GoodInfo> search(String key);

    List<GoodInfo> searchInTitle(String key);

    List<GoodInfo> searchInDescription(String key);



}
