package lb.study.feign.fille.feignfileserver.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/1/4 17:15
 */
@RestController
@RequestMapping("/lb/study/feign/file/server")
public class FileServerController {

    /**
     * @description 模拟文件服务器，这里只返回文件名称
     * consumes:定义了方法接受的http请求类型；
     * produces：定义了http请求返回的类型。
     * @param file
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2019/1/4 17:19
     */
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestPart(value = "file") MultipartFile file ){
        System.out.println("=======文件来了========"+file);
        return file.getOriginalFilename();
    }
}
