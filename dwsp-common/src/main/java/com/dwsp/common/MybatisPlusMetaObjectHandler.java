package com.dwsp.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName MybatisPlusMetaObjectHandler
 * @Description mybatisPlus自动填充处理
 * @Author zhanguowei
 * @Date 2019/4/30 16:18
 **/
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("create_time", LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("modified_time", LocalDateTime.now(),metaObject);
    }
}
