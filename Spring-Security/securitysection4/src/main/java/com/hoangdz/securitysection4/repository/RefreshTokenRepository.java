package com.hoangdz.securitysection4.repository;

import com.hoangdz.securitysection4.model.RefreshToken;
import com.hoangdz.securitysection4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    @Modifying
    Integer deleteByUser(User user);
}
