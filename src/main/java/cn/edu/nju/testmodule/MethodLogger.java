package cn.edu.nju.testmodule;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 测试模块日志输出切面
 */
@Aspect
@Component
@Conditional(TestModuleCondition.class)
public class MethodLogger {

    private static final Logger logger = LoggerFactory.getLogger(MethodLogger.class);

    @Pointcut("execution(* cn.edu.nju..*.*(..))")
    public void methodInvoke() {}

    @Before("methodInvoke()")
    public void logEnterMethod(JoinPoint joinPoint) {
        Signature sig = joinPoint.getSignature();
        logger.info("@Before: 进入方法 "+sig.getDeclaringTypeName()+"."+sig.getName()+" --> 参数为: "+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "methodInvoke()", returning = "returnValue")
    public void logLeaveMethod(JoinPoint point, Object returnValue) {
        Signature sig = point.getSignature();
        logger.info("@Return: 离开方法 "+sig.getDeclaringTypeName()+"."+sig.getName()+"("+Arrays.toString(point.getArgs())+") --> 返回值为 "+returnValue);
    }

    @AfterThrowing(pointcut = "methodInvoke()", throwing = "ex")
    public void logException(JoinPoint point, Throwable ex) {
        Signature sig = point.getSignature();
        logger.error("@Throw: 异常抛出方法 "+sig.getDeclaringTypeName()+"."+sig.getName()+" --> 参数为: "+ Arrays.toString(point.getArgs()), ex);
//        logger.error(Arrays.toString(ex.getStackTrace()));
    }
}
