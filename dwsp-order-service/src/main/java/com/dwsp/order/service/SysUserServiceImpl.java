package com.dwsp.order.service;

import com.dwsp.order.api.dto.SysUserDto;
import com.dwsp.order.api.service.ISysUserService;
import com.dwsp.order.dao.SysUserDao;
import com.dwsp.order.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: <br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/8/13 17:21 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
@Service
@Slf4j
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public Boolean saveUser(SysUserDto sysUserDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDto, sysUser);
        sysUserDao.save(sysUser);
        return Boolean.TRUE;
    }
}
