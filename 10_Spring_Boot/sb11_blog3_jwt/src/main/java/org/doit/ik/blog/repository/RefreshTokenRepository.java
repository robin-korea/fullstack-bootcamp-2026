package org.doit.ik.blog.repository;

import java.util.Optional;

import org.doit.ik.blog.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	
	Optional<RefreshToken> findByUserId(Long userId);
	Optional<RefreshToken> findByRefreshToken(String refreshToken);
	   
	void deleteByRefreshToken(String token);
	void deleteByUserId(Long userId);
	
}
