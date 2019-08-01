package com.dwsp.gateway.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description: 自定义AuthenticationToken<br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/7/31 14:36 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
