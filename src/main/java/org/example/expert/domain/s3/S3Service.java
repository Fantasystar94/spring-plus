//package org.example.expert.domain.s3;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class S3Service {
//    private final AmazonS3 amazonS3;
//
//    @Value("${aws.s3.bucket}")
//    private String bucket;
//    //액세스 키 AKIAU4ZNST6MOBEE5VMP
//    //비밀 액세스 키 XA0599ixelKQtSihFR2P68tnksVl6aIqCE52eE7L
//    public String uploadProfile(MultipartFile file) throws IOException {
//        String fileName = "profile/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
//
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(file.getSize());
//        metadata.setContentType(file.getContentType());
//
//        amazonS3.putObject(bucket, fileName, file.getInputStream(), metadata);
//
//        return amazonS3.getUrl(bucket, fileName).toString();
//    }
//
//}
