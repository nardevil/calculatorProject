package com.vp.calculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorldMethod(@RequestParam(value = "broj1") String broj1, @RequestParam(value = "broj2") String broj2){
        double result = Double.valueOf(broj1) + Double.valueOf(broj2);
        return String.valueOf(result);
    }
}
