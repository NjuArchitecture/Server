package cn.edu.nju.service.dataInit;

import org.junit.Test;

/**
 * Created by sbin on 2017/4/8.
 */
public class GoodDataCreatorTest {

    GoodDataCreator goodDataCreator = new GoodDataCreator();

    @Test
    public void createGoodData() throws Exception {
        System.out.println(goodDataCreator.create().get(0));
    }

    @Test
    public void parseOneGood() throws Exception {

    }

}