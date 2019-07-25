package com.dwsp.customer.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CustomerStuDto
 * @Description
 * @Author Mint
 * @Date 2019/4/30 14:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerStuDto implements Serializable {

    private Long id;

    private String stuName;

    private Integer stuAge;

    private String stuSex;

    private String stuCellPhone;

}
