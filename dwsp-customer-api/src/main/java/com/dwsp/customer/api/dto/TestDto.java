package com.dwsp.customer.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TestDto
 * @Description
 * @Author Mint
 * @Date 2019/4/29 17:17
 **/
@Data
@AllArgsConstructor
public class TestDto implements Serializable {

    private String testId;

    private String message;
}
