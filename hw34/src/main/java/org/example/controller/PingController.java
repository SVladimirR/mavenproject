package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
@Slf4j
public class PingController {
    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @GetMapping
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, "ping"));
        return "OK";
    }
}
