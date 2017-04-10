package cn.edu.nju.testmodule;

/**
 * 根据异常类型解析错误码
 */
public interface ErrorCodeAnalyser {
    public String analyse(Throwable e);
}
