package com.arc.core.model.dto.demo;

import com.arc.core.enums.common.EnableEnum;
import com.arc.core.enums.system.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * demoDto
 *
 * @author may
 * @since 30.6.21 3:14 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoDTO implements Serializable {

    private Long id;//主键id
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 简单枚举测试,db中列是varchar 映射到 简单枚举
     */
    private EnableEnum enable;

    /**
     * 性别,复杂枚举测试,db中是数字 映射到 复杂枚举 EMUN1(1,"message")
     */
    private GenderEnum gender;
}
