package cn.edu.nju.dataservice;

import cn.edu.nju.dataservice.dao.SearchDataRepository;
import cn.edu.nju.utility.GoodInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Qiang
 * @since 08/04/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Commit
public class SearchDataServiceTest {

    @Autowired
    SearchDataService searchDataService;

    @Autowired
    SearchDataRepository searchDataRepository;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        searchDataService.empty();
    }




    @Test
    public void search() throws Exception {
    }

    @Test
    public void persist() throws Exception {

        List<GoodInfo> goodInfos = new ArrayList<>();

        goodInfos.add(new GoodInfo("asd  asdf" ,  " a huawei phone" , "d" , "s" , 300));

        goodInfos.add(new GoodInfo(" Huawei asdf" ,  " a huawei phone" , "d" , "s" , 300));
        goodInfos.add(new GoodInfo(" Huawei2 asdf" ,  " a huawei2 phone" , "d" , "s" , 300));
        goodInfos.add(new GoodInfo("asd Huawei3 asdf" ,  " a huawei3 phone" , "d" , "s" , 300));
        goodInfos.add(new GoodInfo("asd Huawei4 asdf" ,  " a huawei4 phone" , "d" , "s" , 300));

        searchDataService.persist(goodInfos);
    }

    @Test
    public void searchInTitle() throws Exception {
        persist();
        List<GoodInfo> result = searchDataService.search("Huawei");
        List<GoodInfo> result2 = searchDataService.searchInTitle("huawei");
        List<GoodInfo> result3 = searchDataService.searchInDescription("huawei");
//        Iterable<GoodInfo> result = searchDataRepository.findAll();
        result.forEach(System.out::println);


    }

    @Test
    public void searchInDescription() throws Exception {
    }

}