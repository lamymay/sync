package com.arc.core.model.domain.system.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统RBAC-用户用户组关系表
 *
 * @author 叶超
 * @since 2018/12/26 11:28
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@TableName("security_user_user_group")
public class UserUserGroup implements Serializable {

    /*
CREATE TABLE `security_user_user_group` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `user_group_id` bigint NOT NULL COMMENT '角色组ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid_usergroupid` (`user_id`,`user_group_id`) USING BTREE COMMENT '唯一索引:用户-用户组'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统RBAC-用户用户组关系表';

*/
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id

    private Long userId;// 用户id

    private Long userGroupId;// 用户组id usergroupid

//    private Date createTime;// 创建时间
//    private Date updateTime;// 更新时间
//    private String creator;//创建者
//    private String editor;//更新者

    public UserUserGroup() {
    }

    public UserUserGroup(Long userId, Long userGroupId) {
        this.userId = userId;
        this.userGroupId = userGroupId;
    }
}
