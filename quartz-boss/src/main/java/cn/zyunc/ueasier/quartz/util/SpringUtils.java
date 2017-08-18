package cn.zyunc.ueasier.quartz.util;

import java.util.Map;

import org.springframework.context.ApplicationContext;

public class SpringUtils {

    private static ApplicationContext applicationContext;

    private static boolean init = false;

    public static synchronized void setCtx(ApplicationContext applicationContext){
        if(!init){
            SpringUtils.applicationContext = applicationContext;
            init = true;
        }
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    public static <T> T getBean(String beanName) {
        if(applicationContext.containsBean(beanName)){
            return (T) applicationContext.getBean(beanName);
        }else{
            return null;
        }
    }

    public static <T> Map<String, T> getBeansByType(Class<T> baseType){
        return applicationContext.getBeansOfType(baseType);
    }
}