package com.dwsp.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dwsp.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhanguowei
 * @since 2019-08-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_user")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话
     */
    private String cellPhone;

    /**
     * 删除标识
     */
    private Integer deleteFlag;

    public static final String NAME = "name";

    public static final String AGE = "age";

    public static final String CELL_PHONE = "cell_phone";

    public static final String DELETE_FLAG = "delete_flag";

}
