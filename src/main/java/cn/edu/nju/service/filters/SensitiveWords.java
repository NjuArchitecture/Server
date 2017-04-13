package cn.edu.nju.service.filters;

public class SensitiveWords {

	private String[] sensitiveWords={"枪支","弹药","烟花","爆竹","毒品"};

	public String[] getSensitiveWords() {
		return sensitiveWords;
	}

	public void setSensitiveWords(String[] sensitiveWords) {
		this.sensitiveWords = sensitiveWords;
	}
	
	
	
	
}
