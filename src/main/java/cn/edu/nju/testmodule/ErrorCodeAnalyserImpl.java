package cn.edu.nju.testmodule;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现错误码解析
 */
@Component
@Conditional(TestModuleCondition.class)
public class ErrorCodeAnalyserImpl implements ErrorCodeAnalyser {

    private Map<String, String> errorCodeMap;

    public ErrorCodeAnalyserImpl() {
        errorCodeMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("config/ExceptionMapping.map")));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] ss = line.split("\\s+");
                if (ss.length == 2){
                    errorCodeMap.put(ss[0], ss[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String analyse(Throwable e) {
        String className = e.getClass().getName();
        String code = errorCodeMap.getOrDefault(className, "-1");
        return code;
    }
}
