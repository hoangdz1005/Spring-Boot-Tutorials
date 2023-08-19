package com.hoangdz.securitysection2.controller;

import com.hoangdz.securitysection2.jwt.JwtUtils;
import com.hoangdz.securitysection2.model.ERole;
import com.hoangdz.securitysection2.model.Role;
import com.hoangdz.securitysection2.model.User;
import com.hoangdz.securitysection2.payload.request.SigninRequest;
import com.hoangdz.securitysection2.payload.request.SignupRequest;
import com.hoangdz.securitysection2.payload.response.SigninResponse;
import com.hoangdz.securitysection2.repository.RoleRepository;
import com.hoangdz.securitysection2.repository.UserRepository;
import com.hoangdz.securitysection2.service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class AuthController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
        String userName = request.getUsername();
        if(userRepository.existsByUsername(userName)) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        String email = request.getEmail();
        if(userRepository.existsByEmail(email)) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        User user = new User(request.getUsername(), request.getEmail(), encoder.encode(request.getPassword()));
        Set<Role> roles = new HashSet<>();
        Set<String> strRoles = request.getRoles();
        if(strRoles==null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER);
            roles.add(userRole);
        } else {
            strRoles.forEach(role ->{
                if(role.equals("admin")) {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER);
                    roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully!");
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody SigninRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new SigninResponse(jwt, signinRequest.getUsername(), userDetails.getEmail(), roles));
    }
}
