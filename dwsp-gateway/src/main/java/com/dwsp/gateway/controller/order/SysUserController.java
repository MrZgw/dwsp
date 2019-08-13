package com.dwsp.gateway.controller.order;

import com.dwsp.order.api.dto.SysUserDto;
import com.dwsp.order.api.service.ISysUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: <br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/8/13 17:25 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Reference
    private ISysUserService sysUserService;

    @PostMapping("/save")
    public Boolean saveUser(@RequestBody SysUserDto sysUserDto) {
        return sysUserService.saveUser(sysUserDto);
    }
}
