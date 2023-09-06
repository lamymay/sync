package com.arc.core.model.domain.system.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统资源抽象
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@TableName("security_resource")
public class SysResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;//自增主键ID

    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间

    private String name;// 资源名

    /**
     * 资源类型: API,FILE
     */
    private String type;
    @Deprecated
    private Integer priority;// 优先级

    private String method;// 请求方法（GET/POST/PUT/DELETE...）
    private String path;// 资源路径
    private String remark;// 备注

    private Integer status;// state所指的状态，一般都是有限的、可列举的，status则是不可确定的


}

/*
ALTER TABLE `zero`.`security_resource_http`
CHANGE COLUMN `resource_name` `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源名称' AFTER `id`,
CHANGE COLUMN `note` `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '注释' AFTER `path`,
MODIFY COLUMN `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型' AFTER `name`,
MODIFY COLUMN `priority` int NULL DEFAULT 0 COMMENT '优先级' AFTER `type`,
MODIFY COLUMN `parent_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级ID' AFTER `remark`,
ADD COLUMN `status` int NULL COMMENT 'state所指的状态，一般都是有限的、可列举的，status则是不可确定的state所指的状态，一般都是有限的、可列举的，status则是不可确定的\n' AFTER `parent_id`;
*/
