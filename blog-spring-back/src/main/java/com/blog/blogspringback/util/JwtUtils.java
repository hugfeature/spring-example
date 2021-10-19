/*
 * @Author: 丑牛
 * @Date: 2021-10-18 15:00:59
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-19 15:38:47
 * @Description: file content
 */
package com.blog.blogspringback.util;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "blog.blogspringback.jwt")
public class JwtUtils {
    private static String secret;
    private long expire;
    private String header;
    
    /**
     * @description: 生成token
     * @param {long} userId
     * @return {JWT token}
     * @Author: 丑牛
     */
    public String generateToken(long userId){
        // 过期时间
        Date dateNow = new Date();
        Date dateExpire =  new Date(dateNow.getTime() + expire * 1000);
        return Jwts.builder()
                   .setHeaderParam("type", "JWT")
                   .setSubject(userId + "")
                   .setIssuedAt(dateNow)
                   .setExpiration(dateExpire)
                   .signWith(SignatureAlgorithm.HS512, secret)
                   .compact();
    }

    public static Claims getClaimsByToken(String token){
        try {
            return Jwts.parser()
                       .setSigningKey(secret)
                       .parseClaimsJws(token)
                       .getBody();
        } catch (Exception e) {
            log.debug("token error", e);
            return null;
        }
    }

    /**
     * @description: 判断token是否过期
     * @param {Date} expeiration
     * @return true:过期；false：未过期
     * @Author: 丑牛
     */
    public boolean isTokenExpired(Date expeiration){
        return expeiration.before(new Date());
    }
}

