package org.example.expert.domain.log.service;

import lombok.extern.slf4j.Slf4j;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.log.entity.Logs;
import org.example.expert.domain.log.repository.LogRepository;
import org.example.expert.domain.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static jakarta.transaction.Transactional.TxType.REQUIRES_NEW;

@Slf4j
@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void loggingSaveManager(AuthUser user) {

        log.info("매니저 요청 로그 - id:{}, email:{}, nickname:{}", user.getId(), user.getEmail(), user.getNickname());
        Logs logs = new Logs(user.getId(), user.getEmail(), user.getNickname());
        logRepository.save(logs);
    }
}
