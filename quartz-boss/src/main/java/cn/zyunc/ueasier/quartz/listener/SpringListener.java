package cn.zyunc.ueasier.quartz.listener;

import cn.zyunc.ueasier.quartz.util.SpringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * @author sangaizhi
 * @date 2017/8/18
 */
public class SpringListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        ServletContext context = event.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        SpringUtils.setCtx(ctx);
    }
}
