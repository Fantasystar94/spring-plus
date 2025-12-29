package org.example.expert.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
<<<<<<< HEAD
import org.aspectj.lang.annotation.Before;
=======
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AdminAccessLoggingAspect {

    private final HttpServletRequest request;

<<<<<<< HEAD
    @Before("execution(* org.example.expert.domain.user.controller.UserController.getUser(..))")
=======
    @After("execution(* org.example.expert.domain.user.controller.UserController.getUser(..))")
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
    public void logAfterChangeUserRole(JoinPoint joinPoint) {
        String userId = String.valueOf(request.getAttribute("userId"));
        String requestUrl = request.getRequestURI();
        LocalDateTime requestTime = LocalDateTime.now();

        log.info("Admin Access Log - User ID: {}, Request Time: {}, Request URL: {}, Method: {}",
                userId, requestTime, requestUrl, joinPoint.getSignature().getName());
    }
}
