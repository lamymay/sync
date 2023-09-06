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
 * 用户相关的服务
 * V1.0 Group-->User-->Role-->Resource
 * V2.0 Group-->UserGroup-->User-->RoleGroup-->Role-->ResourceGroup-->Resource
 * V3.0 User-->UserGroup-->Role-->Resource
 *
 * @author 叶超
 * @since 2018/12/26 11:28
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@TableName("security_user")
public class User implements Serializable {
    /*

---
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL COMMENT '自增ID',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图像',

  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `gender` int DEFAULT NULL COMMENT '性别｛0未知/1男/2女｝',
  `level` int DEFAULT NULL COMMENT '级别',
  `code` varchar(64) DEFAULT NULL COMMENT '编号',
  `sign` varchar(255) DEFAULT NULL,
  `user_type` int DEFAULT NULL COMMENT '用户类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `state` int DEFAULT NULL COMMENT '状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `editor` varchar(255) DEFAULT NULL COMMENT '最后编辑者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


---
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '账号姓名',
  `cellphone` varchar(20) DEFAULT NULL COMMENT '移动电话号码',
  `email` varchar(128) DEFAULT NULL COMMENT '电子邮箱',
  `state` int DEFAULT '0' COMMENT '账号状态(？0：正常 1:暂停,state表示一个确定的状态集中的某个状态（比如水的三态），status表示一种笼统的情形（比如你的生活状态、工作状态），不存在确定的状态集))',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `latest_time` datetime DEFAULT NULL COMMENT '最新时间',
  `open_id` varchar(255) DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `subscribe` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sex` int DEFAULT NULL,
  `head_image_url` varchar(255) DEFAULT NULL,
  `subscribe_time` datetime DEFAULT NULL,
  `unsubscribe_time` datetime DEFAULT NULL,
  `becomeVip_time` datetime DEFAULT NULL,
  `totalPoint` bigint DEFAULT NULL,
  `cardNumber` varchar(255) DEFAULT NULL,
  `vipLevel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COMMENT='系统用户表';


--- 2022/03/19
CREATE TABLE `security_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id,具有业务含义，全局标识用户唯一的ID',
  `code` varchar(32) NOT NULL COMMENT '编号，全局标识用户唯一的编码字符串格式',
  `status` int NOT NULL DEFAULT '0' COMMENT '账号状态(？0：暂停 1:正常,state表示一个确定的状态集中的某个状态（比如水的三态），status表示一种笼统的情形（比如你的生活状态、工作状态），不存在确定的状态集))',

  `display_name` varchar(16) NOT NULL DEFAULT '' COMMENT '用户昵称，nickname用于显示display_name',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '图标',

  `creator` varchar(16) NOT NULL DEFAULT '' COMMENT '创建者',
  `editor` varchar(16) NOT NULL DEFAULT '' COMMENT '更新者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表';

    * */
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id
    private String code;// 编号
    private Integer status;// 状态

    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间
    private String creator;//创建者
    private String editor;//更新者

    //private String name;// 用户名称，保证全局唯一
    //ALTER TABLE `zero`.`security_user`
    //ADD UNIQUE INDEX `uk_display_name`(`display_name`) USING HASH;
    private String displayName;// 用户昵称，保证全局唯一，nickname用于显示 display_name
    private String avatar;// 头像

//    private String remark;//备注
//    private LocalDateTime birthday;// 生日
//    private Integer level; // 级别
//    private Integer gender; // 性别｛0未知/1男/2女｝
//    private Integer userType;

//    @Deprecated
//    private Integer sign;// 标记

//    private Integer root;//是否系统管理员
//
// 其他重要属性
//  @Deprecated  private UserAuth auth;//一种登录方式
//  @Deprecated  private Area area;
//    private List<UserAuth> auths;// 多种登录方式
//    private List<Role> roles;// 多种角色
//    private List<Area> areas;// 多个区域

    public User() {
    }

    public User(String displayName) {
        this.displayName = displayName;
    }

    public User(Long id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public User(String displayName, String avatar) {
        this.displayName = displayName;
        this.avatar = avatar;
    }

    public static User builtNoLoginUser() {
        return new User();
    }

}
