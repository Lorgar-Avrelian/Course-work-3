package telegrambot.service;

import java.time.LocalDateTime;

public interface NotificationTaskService {
    void sendNotificationTasks(LocalDateTime dateTime);
}
