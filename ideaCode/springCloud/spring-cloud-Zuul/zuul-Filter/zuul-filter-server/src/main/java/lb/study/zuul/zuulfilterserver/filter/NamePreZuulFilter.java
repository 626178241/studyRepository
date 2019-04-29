package lb.study.zuul.zuulfilterserver.filter;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 用来判断name是否存在的Filter
 * @author libo@citycloud.com.cn
 * @date 2019/4/29 11:38
 */
@Component
@Slf4j
public class NamePreZuulFilter extends ZuulFilter {

    private static Gson gson = new Gson();
    private Map params = new LinkedHashMap();

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("进入NamePreZuulFilter-----------");
        //取得Request对象并取name参数
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        request.setAttribute("libo","李波");
        //通过设置request到context中，判断待会路由到下级是否是同一个请求
        requestContext.set("request",request);
        System.out.println("NamePreZuulFilter--request-----------"+request);//这里的request跟源服务那里的request是不同的，所以底层是一个新的请求
        String name = request.getParameter("name");
        if(name == null){//如果不存在name
            //则禁止路由下级服务,但还是会被下个Filter拦截哦，别理解错了
            requestContext.setSendZuulResponse(false);
            //设置返回body，也作为下级判断
            params.put("msg","姓名不能为空");
            params.put("lastDate",new Date());
            requestContext.setResponseBody(gson.toJson(params));
            //logic-is-success执行标识保存在上下文中，可作为同类型下游Filter的开关
            requestContext.set("logic-is-success",false);
            //结束
            return null;
        }
        //成功，设置logic-is-success执行标识
        requestContext.set("logic-is-success",true);
        return null;
    }
}
