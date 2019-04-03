package lb.study.feign.file.feignuploadclient.controller;

import lb.study.feign.file.feignuploadclient.feign.FielServerFeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/1/4 17:23
 */
@RestController
@RequestMapping("/lb/study/feign/file/client")
public class FileUploadController {

    @Resource
    private FielServerFeignClient fielServerFeignClient;

    /**
     * @description
     * @param file
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2019/1/4 17:25
     */
    @RequestMapping(value = "/clientFileUpload",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestPart(value = "file") MultipartFile file ){
        return fielServerFeignClient.fileFeignUpload(file);
    }
}
