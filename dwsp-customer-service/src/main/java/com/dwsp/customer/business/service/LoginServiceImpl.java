package com.dwsp.customer.business.service;

import com.dwsp.customer.api.service.ILoginService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Description: <br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/7/31 09:09 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
@Service
public class LoginServiceImpl implements ILoginService {

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username, String password) {
        return null;
    }
}
