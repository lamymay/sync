package com.arc.core.model.domain.app.api;

import lombok.Data;

/**
 * api所在应用 实际名称应该是api_system
 * api_system
 *   |
 *   |-- 接口1
 *   |-- api2
 *   |-- api3
 *
 */
@Data
public class ApiSystem {

    /*
  CREATE TABLE `api_system` (
  `id` int NOT NULL AUTO_INCREMENT,
  `person_in_charge` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '负责人',
  `group` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `system_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '系统名',
  `caller_name` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '调用方名称',
  `owners` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '调用方负责人',
  `owner_id` bigint DEFAULT NULL COMMENT '调用方负责人的id',
  `quantity` int DEFAULT NULL COMMENT '设置的最大访问量',
  `desc` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '调用方描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=640 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='接口使用情况';
*/

    /**
     *主键id
     */
    private Long id;

    /**
     * 预计调用量
     */
    private Integer quantity;

    /**
     *接口使用方涉及人
     */
    private String owners;

    /**
     * 负责人
     */
    private String personInCharge;

    /**
     * 组织
     */
    private String group;

    /**
     * 调用者,接口使用方
     */
    private String callerName;

    /**
     *系统名称,接口提供方所在系统
     */
    private String systemName;

    /**
     *描述
     */
    private String desc;

    public ApiSystem(   ) {

    }

    public ApiSystem(String systemName) {
        this.systemName = systemName;

    }

    public ApiSystem(String personInCharge, String group, String systemName) {
        this.personInCharge = personInCharge;
        this.group = group;
        this.systemName = systemName;
    }
}
