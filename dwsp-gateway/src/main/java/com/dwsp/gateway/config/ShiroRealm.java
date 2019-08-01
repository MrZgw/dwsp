package com.dwsp.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @Description: shiroRealm <br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/7/31 14:32 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
@Component
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String token = String.valueOf(authenticationToken.getPrincipal());

        //
        //获取用户id
        return null;
    }
}
