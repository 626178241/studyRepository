package lb.study.zuul.zuulfilterserver.filter;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * 源服务返回结果类型
 * @author libo@citycloud.com.cn
 * @date 2019/4/29 14:19
 */
@Component
@Slf4j
public class PostZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("进入PostZuulFilter-----------");
        //上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info((String)request.getAttribute("libo"));
        //取response对象
        HttpServletResponse response = requestContext.getResponse();
        //响应字符类型
        response.setCharacterEncoding("utf-8");
        //获取上下文中保存的responseBody
        String responseBody = requestContext.getResponseBody();
        if(responseBody != null){//如果不为空，则说明存在异常流程（上面只有在异常的时候设置这个）
            //设置响应信息
            requestContext.setResponseBody(responseBody);
            requestContext.setResponseStatusCode(500);
        }
        return null;
    }
}
