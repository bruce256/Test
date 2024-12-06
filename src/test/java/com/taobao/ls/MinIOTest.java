package com.taobao.ls;


import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.http.Method;
import org.junit.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * @auther: LvSheng
 * @date: 2024/12/6
 * @description:
 */
public class MinIOTest {

    @Test
    public void presign() {
        MinioClient minioClient = MinioClient.builder()
                                             .endpoint("http://127.0.0.1:9000")
                                             .credentials("avrfdmwPyU7rr2LY4m7z",
                                                 "0fhIuMKsPcTEDITfGHxMscFBYvy1WfCovSYl5TuO")
                                             .build();

        try {
            String url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                                                                                    .bucket("lvsheng")
                                                                                    .method(Method.PUT)
                                                                                    .object("osskey")
                                                                                    .expiry(10, TimeUnit.MINUTES)
                                                                                    .build());
            System.out.println(url);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        }

    }
}
