package com.dwsp.customer.api.service;

/**
 * @Description: 登录接口
 * @Project: dwsp
 * @CreateDate: Created in 2019/7/31 09:07
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
public interface ILoginService {

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);
}
