package org.doit.ik.blog.service;

import org.doit.ik.blog.domain.RefreshToken;
import org.doit.ik.blog.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
	
	private final RefreshTokenRepository refreshTokenRepository;
	
	// 1. Refresh Token 저장: save
    @Transactional
    public RefreshToken save(Long userId, String refreshToken) {
        RefreshToken refreshTokenEntity = refreshTokenRepository
                                         .findByUserId(userId)
                                          .orElseGet(() -> new RefreshToken(userId, refreshToken) );
        refreshTokenEntity.update(refreshToken);
        return refreshTokenRepository.save(refreshTokenEntity);
    }

    // 2. Refresh Token으로 DB에서 토큰 조회: findByRefreshToken
    @Transactional
    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException( "존재하지 않는 Refresh Token입니다."));
    }

    // 3. Refresh Token 삭제: deleteByRefreshToken
    @Transactional
    public void deleteByRefreshToken(String refreshToken) {
        refreshTokenRepository.deleteByRefreshToken(refreshToken);
    }
    
    // 3-2. Refresh Token 삭제
    @Transactional
    public void deleteByRefreshToken(Long userId) {
       refreshTokenRepository.deleteByUserId(userId);
    }
    
    // 4. Refresh Token이 DB에 존재하는지 확인: existsByRefreshToken 
    @Transactional(readOnly = true)
    public boolean existsByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken).isPresent();
    }
	
}
