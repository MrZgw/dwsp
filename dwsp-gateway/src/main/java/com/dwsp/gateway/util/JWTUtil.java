package com.dwsp.gateway.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

/**
 * @Description: jwt工具类
 * @Project: dwsp
 * @CreateDate: Created in 2019/7/31 09:13
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
@Slf4j
public class JWTUtil {

    /**
     * 加密秘钥
     */
    public static final String secret = "123456";

    public static final String ISSUER = "zgw";

    /**
     * 生成token
     *
     * @param userId
     * @param timeOutMillis
     * @return
     */
    public static String createToken(String userId, Long timeOutMillis) {

        LocalDateTime nowTime = LocalDateTime.now();
        //生成token
        JWTCreator.Builder builder = JWT.create()
                .withIssuer(ISSUER)//签发者
                .withIssuedAt(Date.from(nowTime.toInstant(ZoneOffset.of("+8"))))//签发时间
                .withSubject(userId);//用户ID
        Optional.ofNullable(timeOutMillis).ifPresent(timeOut -> {
            //过期时间
            Long expireMillis = nowTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() + timeOut;
            builder.withExpiresAt(new Date(expireMillis));
        });
        //头部信息存放在Algorithm中
        return builder.sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static Boolean verifierToken(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).withIssuer(ISSUER).build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("token验证失败:{}", e.getMessage());
            return Boolean.FALSE;
        }
    }

    /**
     * 获取userId
     *
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        return JWT.decode(token).getSubject();
    }


    public static void main(String[] args) {
        String token = createToken("123", null);
        log.info(token);
        log.info(verifierToken(token).toString());
        log.info(getUserId(token));

    }
}
