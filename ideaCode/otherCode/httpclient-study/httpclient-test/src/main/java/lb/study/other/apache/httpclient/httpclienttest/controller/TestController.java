package lb.study.other.apache.httpclient.httpclienttest.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/31 14:13
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private Map map = new HashMap();

    {
        map.put("name","libo");
        map.put("age","18");
        map.put("sex","男");
        map.put("time",new Date());
    }

    @GetMapping("/getUser")
    public Map getUser(){
        return map;
    }

    @PostMapping("/updateUser")
    public Map updateUser(@RequestParam Map params ){
        map = params;
        return map;
    }
}
