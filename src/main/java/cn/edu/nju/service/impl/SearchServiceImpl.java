package cn.edu.nju.service.impl;

import cn.edu.nju.dataservice.SearchDataService;
import cn.edu.nju.service.SearchService;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qiang
 * @since 07/04/2017
 */
@Service
public class SearchServiceImpl implements SearchService {

    private final
    SearchDataService searchDataService;

    @Autowired
    public SearchServiceImpl(SearchDataService searchDataService) {
        this.searchDataService = searchDataService;
    }

    @Override
    public List<GoodInfo> search(String key) {
        List<GoodInfo> goodInfos = searchDataService.search(key);

        return goodInfos;
    }

    @Override
    public List<GoodInfo> searchInTitle(String key) {
        return searchDataService.searchInTitle(key);
    }

    @Override
    public List<GoodInfo> searchInDescription(String key) {
        return searchDataService.searchInDescription(key);
    }

}
