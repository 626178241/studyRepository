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
 * 接着判断age是否传过来
 * @author libo@citycloud.com.cn
 * @date 2019/4/29 13:58
 */
@Component
@Slf4j
public class AgePreZuulFilter extends ZuulFilter {
    private static Gson gson = new Gson();
    private Map params = new LinkedHashMap();

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        //这里从上下文中取执行标识，并设置是否执行此Filter
        RequestContext requestContext = RequestContext.getCurrentContext();
        boolean bool = (boolean)requestContext.get("logic-is-success");
        return bool;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("进入AgePreZuulFilter-----------");
        //取得Request对象并取name参数
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info((String)request.getAttribute("libo"));
        String age = request.getParameter("age");
        if(age==null){
            //则禁止路由下级服务,但还是会被下个Filter拦截哦，别理解错了
            requestContext.setSendZuulResponse(false);
            //设置返回body，也作为下级判断
            params.put("msg","年龄不能为空");
            params.put("lastDate",new Date());
            requestContext.setResponseBody(gson.toJson(params));
            //logic-is-success执行标识保存在上下文中，可作为同类型下游Filter的开关
            requestContext.set("logic-is-success",false);
            //结束
            return null;
        }
        //前面优先的FIlter设置默认logic-is-success=true了 这里就不设置了
        return null;
    }
}
