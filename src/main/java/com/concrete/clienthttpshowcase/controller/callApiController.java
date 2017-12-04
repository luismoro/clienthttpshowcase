package com.concrete.clienthttpshowcase.controller;

import com.concrete.clienthttpshowcase.service.CallApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class callApiController {

    @Autowired
    private CallApiService callApiService;

    @RequestMapping(value = "/call")
    public String interceptRequest() throws InterruptedException {

        return String.valueOf(callApiService.callApi());

    }

}
