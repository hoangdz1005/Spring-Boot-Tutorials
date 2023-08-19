package com.hoangdz.securitysection2.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninRequest {
    private String username;
    private String password;
}
