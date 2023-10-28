package telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;
import telegrambot.entity.NotificationTask;
import telegrambot.repository.NotificationTaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationTaskServiceImpl implements NotificationTaskService {
    private final NotificationTaskRepository notificationTaskRepository;
    private final TelegramBot telegramBot;

    public NotificationTaskServiceImpl(NotificationTaskRepository notificationTaskRepository, TelegramBot telegramBot) {
        this.notificationTaskRepository = notificationTaskRepository;
        this.telegramBot = telegramBot;
    }

    @Override
    public void sendNotificationTasks(LocalDateTime dateTime) {
        List<NotificationTask> tasks = notificationTaskRepository.findAllByExecuteDate(dateTime);
        tasks.forEach(t -> {
            telegramBot.execute(new SendMessage(t.getChatId(), t.getText()));
        });
    }
}
