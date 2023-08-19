package com.hoangdz.securitysection4.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninRequest {
    private String username;
    private String password;
}
