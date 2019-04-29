package lb.study.zuul.zuulfilterserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 第一个zuul-Filter
 * pre类型:路由到下游服务之前执行，可做限流、鉴权等这些
 * @author libo@citycloud.com.cn
 * @date 2019/4/28 17:47
 */
@Configuration
@Component
@Slf4j
public class FirstPreZuulFilter extends ZuulFilter {

    /**
     *
     * @return 使用返回值设置Filter类型，可设置pre、route、post、error
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     *
     * @return 使用返回值设置filter执行次序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *
     * @return 使用返回值设值改Filter是否执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return 核心执行逻辑
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        log.info("========================这是第一个自定义的Zuul-filter");
        return null;
    }
}
