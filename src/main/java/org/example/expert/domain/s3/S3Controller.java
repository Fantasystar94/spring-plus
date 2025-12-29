//package org.example.expert.domain.s3;
//
//import org.example.expert.domain.common.dto.AuthUser;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/users")
//public class S3Controller {
//    private final S3Service s3Service;
//
//    public S3Controller(S3Service s3Service) {
//        this.s3Service = s3Service;
//    }
//
//    @PostMapping("/profile-image")
//    public ResponseEntity<String> uploadProfile(
//            @AuthenticationPrincipal AuthUser authUser,
//            @RequestPart MultipartFile profileImage) throws IOException {
//        String imageUrl = s3Service.uploadProfile(profileImage);
//        return ResponseEntity.ok(imageUrl);
//    }
//}
