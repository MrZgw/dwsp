package com.dwsp.order.api.service;

import com.dwsp.order.api.dto.SysUserDto;

/**
 * @Description: <br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/8/13 17:15 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
public interface ISysUserService {

    Boolean saveUser(SysUserDto sysUserDto);
}
