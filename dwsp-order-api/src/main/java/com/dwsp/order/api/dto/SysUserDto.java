package com.dwsp.order.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: <br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/8/13 17:15 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
@Data
public class SysUserDto implements Serializable {

    private String name;

    private Integer age;

    private String cellPhone;

}
