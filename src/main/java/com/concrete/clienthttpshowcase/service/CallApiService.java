package com.concrete.clienthttpshowcase.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class CallApiService {

    private final RestTemplate restTemplate;

    public CallApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Object> callApi() throws InterruptedException {
        String url = "http://10.200.11.127:9000/api/httpContent";
        Object results = restTemplate.getForObject(url, Object.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

}
