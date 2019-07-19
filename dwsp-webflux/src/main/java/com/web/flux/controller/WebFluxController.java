package com.web.flux.controller;

import com.web.flux.entity.WebFlux;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webFlux")
@Slf4j
public class WebFluxController {

    @GetMapping("/")
    public String hello() {
        return "hello webFlux";
    }

    @GetMapping("/{id}")
    public WebFlux getWebFlux(@PathVariable("id") Integer id) {
        log.info("id is : {}", id);
        WebFlux webFlux = new WebFlux("webFlux", "spring.io");
        return webFlux;
    }
}
