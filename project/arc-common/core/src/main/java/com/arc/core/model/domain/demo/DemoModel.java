package com.arc.core.model.domain.demo;

import com.arc.core.enums.common.EnableEnum;
import com.arc.core.enums.system.GenderEnum;
import com.arc.core.model.domain.BaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 枚举属性测试
 *
 * @author yechao
 * @since 2020/9/8 9:40 上午
 */
@Data
@TableName("demo")
public class DemoModel extends BaseModel {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
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
    private EnableEnum enable;//是否可用

    /**
     * 性别,复杂枚举测试,db中是数字 映射到 复杂枚举 EMUN1(1,"message")
     */
    private GenderEnum gender;

}
/*
CREATE TABLE `test_enum_domain` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键PK',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `age` int NOT NULL COMMENT '名称',
  `enable` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否可用',
  `gender` int DEFAULT NULL COMMENT '性别',
  `create_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


* */
