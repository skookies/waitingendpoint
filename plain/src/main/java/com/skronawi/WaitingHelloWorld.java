package com.skronawi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaitingHelloWorld {

    @Value("${sleepSecs:10}")
    private int sleepSecs;

    @RequestMapping
    public String hello() throws InterruptedException {
        Thread.sleep(sleepSecs * 1000);
        return "hello your request was delayed: " + sleepSecs + " seconds";
    }

    @RequestMapping(path = "health")
    public ResponseEntity<Void> health(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
