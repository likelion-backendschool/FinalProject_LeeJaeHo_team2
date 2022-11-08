package com.example.finalProject.infrastructure;

import com.example.finalProject.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationExecutor implements NotificationService {
    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("이메일 전송 완료");
    }
}
