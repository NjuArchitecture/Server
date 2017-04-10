package cn.edu.nju.service.filters;
/**
 * Created by hmy on 2017/3/12.
 */
public class GoodInfo {
//		商品信息：URL（字符串）、来源（字符串）、名称（字符串）、价格（double）、图片URL（字符串）、店铺（字符串）
	
	String URL;
	String source;
	String name;
	Double price;
	String imgURL;
	String shop;
	
	public GoodInfo(String URL,
					String source,
					String name,
					Double price,
					String imgURL,
					String shop){
		
		this.setURL(URL);
		this.setSource(source);
		this.setShop(shop);
		this.setImgURL(imgURL);
		this.setName(name);
		this.setPrice(price);
	}
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	
}
