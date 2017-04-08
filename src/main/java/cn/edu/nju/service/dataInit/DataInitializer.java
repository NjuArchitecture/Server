package cn.edu.nju.service.dataInit;

import cn.edu.nju.dataservice.CommentDataService;
import cn.edu.nju.dataservice.dao.SearchDataRepository;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sbin on 2017/4/8.
 */
@Component
public class DataInitializer implements CommandLineRunner{

    @Autowired
    private CommentDataService commentDataService;
    @Autowired
    private SearchDataRepository searchDataRepository;

    private GoodDataCreator goodDataCreator;

    @Override
    public void run(String... strings) throws Exception {

        if(searchDataRepository.count()>0){
            return;
        }

        goodDataCreator = new GoodDataCreator();
        List<GoodInfo> goodInfos = goodDataCreator.create();

        searchDataRepository.save(goodInfos);

    }
}
