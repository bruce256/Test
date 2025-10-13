package minio;


import io.minio.MinioAsyncClient;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther: LvSheng
 * @date: 2025/10/10
 * @description:
 */
public class PutTest {
    public static void main(String[] args) {
        int coreSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, coreSize, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(100),
            new ThreadPoolExecutor.CallerRunsPolicy());

        OkHttpClient okHttpClient = new OkHttpClient.Builder().dispatcher(new Dispatcher(threadPoolExecutor)).build();
        MinioAsyncClient client =
            MinioAsyncClient.builder()
                            .endpoint("http://127.0.0.1", 9000, false)
                            .credentials("avrfdmwPyU7rr2LY4m7z",
                                "0fhIuMKsPcTEDITfGHxMscFBYvy1WfCovSYl5TuO")
                            .httpClient(okHttpClient)
                            .build();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/LvSheng/Downloads/oom1.gif");
            client.putObject(PutObjectArgs.builder()
                                          .bucket("lvsheng")
                                          .object("oom1.gif")
                                          .stream(fis, fis.available(), -1)
                                          .build()).join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
