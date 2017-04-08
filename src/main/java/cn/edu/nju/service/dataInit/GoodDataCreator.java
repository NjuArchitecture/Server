package cn.edu.nju.service.dataInit;

import cn.edu.nju.utility.GoodInfo;
import org.apache.lucene.analysis.util.ClasspathResourceLoader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sbin on 2017/4/8.
 */
public class GoodDataCreator {

    private String[] filePaths = {"initData/apple_phone.txt","initData/mi_phone.txt"};

    public List<GoodInfo> create(){

        List<GoodInfo> result = new ArrayList<>();
        for(String filePath:filePaths){
            result.addAll(getFileData(filePath));
        }
        return result;
    }

    private List<GoodInfo> getFileData(String filePath){

        Document document;
        try {
            InputStream inputStream = new ClassPathResource(filePath).getInputStream();
            document = Jsoup.parse(inputStream,"UTF-8","");
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        Elements elements = document.select("li.gl-item");

        return elements.stream()
                .filter(element -> !element.attr("data-type").equals("activity"))
                .map(element -> parseOneGood(element))
                .collect(Collectors.toList());

    }

    protected GoodInfo parseOneGood(Element element){
        Element href = element.select(".gl-i-wrap .p-img a").first();

        String url = href.attr("href");
        String pic1 = href.select("img").first().attr("src");
        String pic2 = element.select(".ps-item img").first().attr("src");

        double price = Double.valueOf(
                element.select(".p-price strong i").first().text());

        String title = element.select(".p-name.p-name-type-2 em").text();
        String description = element.select("i.promo-words").text();

        GoodInfo goodInfo = new GoodInfo();
        goodInfo.setTitle(title);
        goodInfo.setDescription(description);
        goodInfo.setId(url);
        goodInfo.setPic1(pic1);
        goodInfo.setPic2(pic2);
        goodInfo.setPrice(price);
        goodInfo.setSourceName("京东");
        goodInfo.setSourceURL(url);

        return goodInfo;
    }

}
