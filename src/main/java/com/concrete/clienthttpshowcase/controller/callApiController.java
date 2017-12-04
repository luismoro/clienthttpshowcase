package java.com.concrete.clienthttpshowcase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class callApiController {


    @RequestMapping(value = "/call")
    public String interceptRequest() {
        return "Works!!!";
    }

}
