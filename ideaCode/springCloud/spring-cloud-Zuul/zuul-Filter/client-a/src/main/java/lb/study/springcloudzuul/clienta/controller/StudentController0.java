package lb.study.springcloudzuul.clienta.controller;

import com.netflix.loadbalancer.RoundRobinRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Map;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/4/15 14:48
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController0 {

    @RequestMapping("/getStudent")
    public String getStudent(HttpServletRequest request){
        int serverPort = request.getServerPort();
        log.error(String.valueOf(serverPort));
        return "这是一个学生"+String.valueOf(serverPort);
    }

    /**
     * @description 添加student
     * @param params
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/4/29 11:33
     */
    @RequestMapping("/addStudent")
    public Object addStudent(@RequestParam Map params ,HttpServletRequest request){
        System.out.println("StudentController--request-----------"+request);
        String name = (String)params.get("name");
        String age = (String)params.get("age");
        if(name==null || age==null){
            throw new RuntimeException("学生姓名跟年龄不能为空！");
        }
        params.put("status",200);
        params.put("msg","添加成功");
        return params;
    }
}
