package cn.edu.nju.dataservice.dao;

import cn.edu.nju.utility.GoodInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 07/04/2017
 */
public interface SearchDataRepository extends ElasticsearchRepository<GoodInfo, String>{
    /**
     * 根据 名字 或 描述中查找 ，  titleKey 一般与 descriptionKey 一样，除非用户指定必须出现在标题或描述中
     * @param titleKey
     * @param descriptionKey
     * @return
     */
    List<GoodInfo> findByTitleContainsOrDescriptionContaining(String titleKey, String descriptionKey);

    List<GoodInfo> findByTitleContains(String titleKey);

    List<GoodInfo> findByDescriptionContains(String descriptionKey);


}
