package com.hoangdz.securitysection2.payload.response;

import com.hoangdz.securitysection2.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SigninResponse {
    private String jwt;
    private String username;
    private String email;
    private List<String> roles;
}
