package cn.edu.nju.service.filters;

/**
 * Created by fwtgm on 2017/4/12.
 */
public class FrequencyWords {
    private static String[] frequencyWords={"好","顶","赞"};

    public static String[] getFrequencyWords() {
        return frequencyWords;
    }

    public static void setFrequencyWords(String[] frequencyWords) {
        FrequencyWords.frequencyWords = frequencyWords;
    }
}
