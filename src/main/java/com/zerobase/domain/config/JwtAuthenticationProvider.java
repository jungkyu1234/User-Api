package com.zerobase.domain.config;

import com.zerobase.domain.config.domain.common.UserVo;
import com.zerobase.domain.config.domain.common.UserType;
import com.zerobase.domain.util.Aes256Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Objects;

public class JwtAuthenticationProvider {
    private String secretKey = "secretKey";
    private long tokenValidTime = 100L * 60 * 60 * 24;

    private String createToken(String userPK, Long id, UserType userType) {
        Claims claims = Jwts.claims().setSubject(userPK);

        // 토큰에 담을 커스텀 클레임 추가
        claims.put("id", id);
        claims.put("userType", userType);

        // 현재 시간
        Date now = new Date();

        // 토큰 생성
        return Jwts.builder()
                .setClaims(claims)                       // 데이터 세팅
                .setIssuedAt(now)                        // 발급시간
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // 만료시간
                .signWith(SignatureAlgorithm.HS256, secretKey)           // 암호화 알고리즘과 키
                .compact();                                             // 직렬화해서 문자열로 변환
    }

    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserVo getUserVo(String token) {
        Claims c = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        String userPk = c.getSubject();
        Long id = Long.valueOf(Aes256Util.decrypt(c.get("id", String.class)));
        UserType userType = UserType.valueOf(c.get("userType", String.class));

        return new UserVo(Long.valueOf(Objects.requireNonNull(Aes256Util.decrypt(c.getId()))), Aes256Util.decrypt(c.getSubject()));

    }
}