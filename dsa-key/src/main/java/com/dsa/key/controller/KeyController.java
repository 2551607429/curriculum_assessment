package com.dsa.key.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/key")
public class KeyController {
    /**
     *
     * @return
     */
    @GetMapping("hello")
    public String hello(){
        return "hello:key";
    }
}
