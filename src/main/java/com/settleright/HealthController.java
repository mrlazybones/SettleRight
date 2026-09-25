package com.settleright;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HealthController {

    @GetMapping("/api/ping")
    public String ping(@RequestParam(required =false)String name){
        if (name == null) {
        return "pong";
        }
        else {
        return "pong, " + name;
        }
    }
}