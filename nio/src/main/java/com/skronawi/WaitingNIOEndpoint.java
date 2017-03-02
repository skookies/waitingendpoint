package com.skronawi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WaitingNIOEndpoint {

    @Value("${sleepSecs:10}")
    private int sleepSecs;

    @RequestMapping
    public Flux<String> hello() throws Exception {
        return Flux.just("hello your request was delayed: " + sleepSecs + " seconds")
                .delay(Duration.ofSeconds(sleepSecs));
    }

    @RequestMapping(path = "health")
    public ResponseEntity<Void> health(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
