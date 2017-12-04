package com.concrete.clienthttpshowcase.component;

import com.concrete.clienthttpshowcase.service.CallApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final CallApiService callApiService;

    @Autowired
    public AppRunner(CallApiService callApiService) {
        this.callApiService = callApiService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<String> page1 = callApiService.callApi("http://10.200.11.127:9000/api/httpTwoAsyncContent");
        CompletableFuture<String> page2 = callApiService.callApi("http://10.200.11.127:9000/api/httpTwoAsyncContent");
        CompletableFuture<String> page3 = callApiService.callApi("http://10.200.11.127:9000/api/httpTwoAsyncContent");

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get(100, TimeUnit.MILLISECONDS));
        logger.info("--> " + page2.get(100, TimeUnit.MILLISECONDS));
        logger.info("--> " + page3.get(100, TimeUnit.MILLISECONDS));
        
    }



}
