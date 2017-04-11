package cn.edu.nju.service.filters;

/**
 * Created by fwtgm on 2017/4/11.
 */
public class BusinessWords {
    private static String[]businessWords={"京东","淘宝"};

    public static String[] getBusinessWords() {
        return businessWords;
    }

    public static void setBusinessWords(String[] businessWords) {
        BusinessWords.businessWords = businessWords;
    }


}
