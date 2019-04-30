package com.dwsp.customer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zhanguowei
 * @since 2019-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_customer_stu")
public class CustomerStu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String stuName;

    private Integer stuAge;

    private Boolean stuSex;

    private String stuCellPhone;


}
