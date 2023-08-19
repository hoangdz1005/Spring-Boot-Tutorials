package com.hoangdz.securitysection4.service;

import com.hoangdz.securitysection4.model.RefreshToken;
import com.hoangdz.securitysection4.model.User;
import com.hoangdz.securitysection4.repository.RefreshTokenRepository;
import com.hoangdz.securitysection4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private final Long refreshTokenDurationMs = 180000L;
    @Autowired
    RefreshTokenRepository refreshTokenRepository;
    @Autowired
    UserRepository userRepository;
    public Optional<RefreshToken> findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByToken(refreshToken);
    }
    public RefreshToken createRefreshToken(Long idUser) {
        RefreshToken refreshToken = new RefreshToken();
        User user = userRepository.findById(idUser).get();
        refreshToken.setUser(user);
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }
    public RefreshToken verifyRefreshToken(RefreshToken refreshToken){
        if(refreshToken.getExpiryDate().compareTo(Instant.now())<0) {
            refreshTokenRepository.delete(refreshToken);
            throw new RuntimeException("Refresh token was expired!");
        }
        return refreshToken;
    }
    public int deleteByUserId(Long userId) {
         User user = userRepository.findById(userId).get();
         return refreshTokenRepository.deleteByUser(user);

    }
}
