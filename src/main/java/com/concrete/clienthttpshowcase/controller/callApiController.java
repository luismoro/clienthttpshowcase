package com.concrete.clienthttpshowcase.controller;

import com.concrete.clienthttpshowcase.service.CallApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class callApiController {

    @Autowired
    private CallApiService callApiService;

    @RequestMapping(value = "/call", method= RequestMethod.GET)
    public CompletableFuture<String> interceptRequest(@RequestParam(value="url", required=true) String url) throws InterruptedException {

        return callApiService.callApi(url);

    }

}
