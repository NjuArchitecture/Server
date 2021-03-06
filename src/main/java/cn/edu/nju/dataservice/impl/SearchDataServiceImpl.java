package cn.edu.nju.dataservice.impl;

import cn.edu.nju.dataservice.SearchDataService;
import cn.edu.nju.dataservice.dao.SearchDataRepository;
import cn.edu.nju.utility.GoodInfo;
import org.elasticsearch.index.query.QueryBuilder;
import static org.elasticsearch.index.query.QueryBuilders.*;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Qiang
 * @since 08/04/2017
 */
@Service
public class SearchDataServiceImpl implements SearchDataService {

    private final ElasticsearchTemplate elasticsearchTemplate;
    private final SearchDataRepository searchDataRepository;

    private final static String TITLE = "title";
    private final static String DESCRIPTION = "description";



    @Autowired
    public SearchDataServiceImpl(SearchDataRepository searchDataRepository, ElasticsearchTemplate elasticsearchTemplate) {
        this.searchDataRepository = searchDataRepository;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }


    @Override
    public List<GoodInfo> search(String key) {
//       return searchWithMultiKeyWords(getKeys(key));

        return searchDataRepository.findByTitleInOrDescriptionIn(getKeys(key), getKeys(key));

    }

    @Override
    public void persist(List<GoodInfo> goods) {

        searchDataRepository.save(goods);
    }

    @Override
    public List<GoodInfo> searchInTitle(String key) {
//        return searchWithMultiKeyWords(TITLE, getKeys(key));

        return searchDataRepository.findByTitleIn(getKeys(key));
    }

    @Override
    public List<GoodInfo> searchInDescription(String key) {

//            return searchWithMultiKeyWords(DESCRIPTION, getKeys(key));

        return searchDataRepository.findByDescriptionIn(getKeys(key));
    }

    @Override
    public List<GoodInfo> findAll() {
        List<GoodInfo> goodInfos = new ArrayList<>(3000);
        searchDataRepository.findAll().forEach(goodInfos::add);
        return goodInfos;
    }

    private static Collection<String> getKeys(String key) {
        String[] splits = key.split(" ");
        List<String> keys = new ArrayList<>(splits.length);
        Collections.addAll(keys, splits);
        return keys;
    }



    @Override
    public void empty() {
        searchDataRepository.deleteAll();
    }





    // Deprecated method, futile now
    private List<GoodInfo> searchWithMultiKeyWords(String field , Collection<String> keys) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();

        for (String key: keys) {
            builder.withQuery(fuzzyQuery(field, key));

        }

        return elasticsearchTemplate.queryForList(builder.build(), GoodInfo.class);
    }


    private List<GoodInfo> searchWithMultiKeyWords(Collection<String> keys) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();

        for (String key: keys) {
            builder.withQuery(fuzzyQuery(TITLE, key));
        }
        for (String key: keys) {
            builder.withQuery(fuzzyQuery(DESCRIPTION, key));
        }
        List<GoodInfo> goodInfo = new ArrayList<>(100);
        searchDataRepository.search(builder.build()).forEach(goodInfo::add);

        return goodInfo;
    }


}
