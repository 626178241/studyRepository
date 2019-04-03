package lb.study.feign.file.feignuploadclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/1/4 17:27
 */
@FeignClient(name = "feign-file-server")
public interface FielServerFeignClient {

    @RequestMapping(value = "/lb/study/feign/file/server/fileUpload",method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileFeignUpload(@RequestPart(value = "file") MultipartFile file);
}
