package telegrambot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import telegrambot.service.NotificationTaskServiceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class Scheduler {
    private final NotificationTaskServiceImpl notificationTaskService;

    public Scheduler(NotificationTaskServiceImpl notificationTaskService) {
        this.notificationTaskService = notificationTaskService;
    }
    @Scheduled(cron = "0 0/1 * * * *")
    public void test() {
        notificationTaskService.sendNotificationTasks(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }
}
