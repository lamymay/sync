package com.arc.core.model.request.demo;

import com.arc.core.enums.common.EnableEnum;
import com.arc.core.enums.system.GenderEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 枚举属性测试
 *
 * @author yechao
 * @since 2020/9/8 9:40 上午
 */
@Data
public class DemoRequest {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 创建时间
     * "2021-07-02T14:06:08.207267" ----OK
     * "2021-07-02T14:06"           ----OK
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    private LocalDateTime createTimeBegin;
    private LocalDateTime createTimeEnd;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 是否可用简单枚举测试,db中列是varchar 映射到 简单枚举
     */
    private EnableEnum enable;

    /**
     * 性别,复杂枚举测试,db中是数字 映射到 复杂枚举 EMUN1(1,"message")
     */
    private GenderEnum gender;

    private int page = 1;

    private int start = 0;

    private int pageSize = 20;


    //////

    public DemoRequest() {
    }
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
