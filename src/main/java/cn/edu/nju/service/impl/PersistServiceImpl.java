package cn.edu.nju.service.impl;

import cn.edu.nju.dataservice.SearchDataService;
import cn.edu.nju.service.PersistService;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qiang
 * @since 10/04/2017
 */
@Service
public class PersistServiceImpl implements PersistService {


    private final
    SearchDataService searchDataService;

    @Autowired
    public PersistServiceImpl(SearchDataService searchDataService) {
        this.searchDataService = searchDataService;
    }

    @Override
    public void persist(List<GoodInfo> goodInfos) {
        searchDataService.persist(goodInfos);
    }
}
