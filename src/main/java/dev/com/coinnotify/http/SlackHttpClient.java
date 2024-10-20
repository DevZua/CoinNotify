package dev.com.coinnotify.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlackHttpClient {

    private static final String WEBHOOK_URL = "https://hooks.slack.com/services/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";

    public void send(String message) {
        System.out.println("Sending message to Slack: " + message); // 로그 출력

        try {
            Slack instance = Slack.getInstance();
            Payload payload = Payload.builder()
                    .text(message)
                    .build();
            instance.send(WEBHOOK_URL, payload);
            System.out.println("Message sent successfully"); // 성공 메시지 로그
        } catch (IOException e) {
            e.printStackTrace(); // 예외 메시지 로그
            throw new RuntimeException("Failed to send message to Slack", e);
        }
    }
}
