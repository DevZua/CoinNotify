package dev.com.coinnotify.service;

import dev.com.coinnotify.http.SlackHttpClient;
import dev.com.coinnotify.http.UpbitHttpClient;
import dev.com.coinnotify.http.UpbitTickerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;

    public void execute(String market){
        // upbit로 호출
        UpbitTickerDto tickerByMarket = upbitHttpClient.getTickerByMarket(market);

        // slack 으로 메시지 전송
        StringBuilder sb = new StringBuilder();
        sb.append("[실시간 데이터] ");
        sb.append(market);
        sb.append(" price = ");
        sb.append(tickerByMarket.getTrade_price());
        slackHttpClient.send(sb.toString());
    }
}
