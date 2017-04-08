package cn.edu.nju.utility;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Qiang
 * @since 07/04/2017
 */
@Document(indexName = "goods", type = "goods", shards = 5, replicas = 1, refreshInterval = "-1")
public class GoodInfo {
    @Id
    private String id;
    private String title;
    private String description;
    private String pic1;
    private String pic2;
    private double price;

    public GoodInfo(String title, String description, String pic1, String pic2, double price) {
        this.title = title;
        this.description = description;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.price = price;
    }
    public GoodInfo() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return String.format("GoodInfo[id=%s, title='%s', description='%s']", this.id,
                this.title, this.description);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
