package com.hoangdz.resourceserver.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class ResourceServerController {
    @GetMapping("/test1")
    public String test() {
        return "Test1 Successfully!";
    }
    @GetMapping("/test2")
    public String test2() {
        return "Test2 Successfully!";
    }
}