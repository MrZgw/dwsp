package com.dwsp.customer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName StuSexEnum
 * @Description
 * @Author Mint
 * @Date 2019/4/30 14:48
 **/
@Getter
@AllArgsConstructor
public enum  StuSexEnum {
    MAN("男"), WOMAN("女"), UNKNOWN("未知");
    private String desc;
}
