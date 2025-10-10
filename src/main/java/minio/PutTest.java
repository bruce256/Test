package minio;


import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @auther: LvSheng
 * @date: 2025/10/10
 * @description:
 */
public class PutTest {
    public static void main(String[] args) {
        MinioClient client =
            MinioClient.builder()
                       .endpoint("http://127.0.0.1", 9000, false)
                       .credentials("avrfdmwPyU7rr2LY4m7z",
                           "0fhIuMKsPcTEDITfGHxMscFBYvy1WfCovSYl5TuO")
                       .build();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/LvSheng/Downloads/oom1.gif");

            client.putObject(PutObjectArgs.builder()
                                          .bucket("lvsheng")
                                          .object("oom1.gif")
                                          .stream(fis, fis.available(), -1)
                                          .build());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        }
    }
}
