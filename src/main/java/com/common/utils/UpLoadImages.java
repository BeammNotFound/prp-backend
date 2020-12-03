package com.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Configuration
public class UpLoadImages {

    /**
     * 上传图片
     * @param file
     * @return
     * @throws IOException
     */

    public String uploadImage(MultipartFile multipartFile) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4GAAbhDkVim18nqhHZf9";
        String accessKeySecret = "e2GMG0JJmQlDWCFF066vjuSzcWIcQl";

        // 创建OSSClient实例。

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = multipartFile.getInputStream();
        String nowDate = "Beam";
        //文件名
        String fileName = multipartFile.getOriginalFilename();
        fileName = nowDate+"/"+ UUID.randomUUID() + fileName;
        ossClient.putObject("club-2020",fileName, inputStream);
        String url = "https://club-2020."+endpoint+"/"+fileName;
        // 关闭OSSClient。
        ossClient.shutdown();
        return url;
    }
}
