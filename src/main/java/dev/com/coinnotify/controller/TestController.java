package dev.com.coinnotify.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.com.coinnotify.http.SlackHttpClient;
import dev.com.coinnotify.http.UpbitHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UpbitHttpClient upbitHttpClient;
    private final SlackHttpClient slackHttpClient;

    @GetMapping("/api/v1/ticker/{market}")
    public void test(@PathVariable String market) throws JsonProcessingException {
        System.out.println("Received request for market: " + market);
        upbitHttpClient.getTickerByMarket(market);
        slackHttpClient.send("hello world");
    }
}
