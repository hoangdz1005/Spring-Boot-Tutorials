package com.hoangdz.securitysection4.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SigninResponse {
    private String jwt;
    private String refreshToken;
    private String username;
    private String email;
    private List<String> roles;
}
