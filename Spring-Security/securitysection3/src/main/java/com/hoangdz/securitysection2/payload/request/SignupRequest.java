package com.hoangdz.securitysection2.payload.request;

import com.hoangdz.securitysection2.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 6)
    private String password;
    private Set<String> roles;

}
