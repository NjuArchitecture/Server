package cn.edu.nju.testmodule;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 测试模块启动条件判断类
 */
public class TestModuleCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String enableTest = context.getEnvironment().getProperty("testmodule.enable");
        return enableTest.equals("true");
    }
}
