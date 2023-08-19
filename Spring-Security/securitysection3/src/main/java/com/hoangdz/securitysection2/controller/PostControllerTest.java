package com.hoangdz.securitysection2.controller;

import com.hoangdz.securitysection2.payload.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerTest {
    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok("Hello, " + signupRequest.getUsername());
    }
}
