package com.arc.core.model.domain.system.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户组
 *
 * @author 叶超
 * @since 2018/12/26 11:28
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@TableName("security_user_group")
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;


    //CREATE TABLE `security_user_group` (
    //  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
    //  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    //  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    //  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    //  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
    //  `editor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
    //  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
    //  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
    //  `status` int DEFAULT NULL COMMENT '状态',
    //  PRIMARY KEY (`id`) USING BTREE
    //) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统RBAC-用户组';

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id

    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间

    private String creator;//创建者
    private String editor;//更新者

    private Integer status;// 状态
    private String name;// 名称

    public UserGroup() {
    }

}
