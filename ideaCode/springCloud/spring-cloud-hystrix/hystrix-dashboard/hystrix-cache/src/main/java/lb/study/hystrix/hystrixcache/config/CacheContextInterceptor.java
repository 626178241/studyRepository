package lb.study.hystrix.hystrixcache.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用拦截器，初始化Hystrix上下文用来测试缓存
 * 这里的拦截器就是springMVC的
 * @author libo@citycloud.com.cn
 * @date 2019/3/18 16:22
 */
public class CacheContextInterceptor implements HandlerInterceptor {

    private HystrixRequestContext hystrixRequestContext;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        hystrixRequestContext = HystrixRequestContext.initializeContext();
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        hystrixRequestContext.shutdown();
    }
}
