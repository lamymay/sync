package com.arc.core.model.domain.system.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统RBAC-用户组到角色关系表-多对多 是中间表 _relation
 *
 * @author 叶超
 * @since 2023/03/01
 */
@Data
@TableName("security_user_group_role")
public class UserGroupRole implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id

    /**
     * 用户组id usergroupid  user_group_id
     */
    private Long userGroupId;

    /**
     * 角色id roleid role_id
     */
    private Long roleId;


    public UserGroupRole() {
    }

    public UserGroupRole(Long userGroupId, Long roleId) {
        this.userGroupId = userGroupId;
        this.roleId = roleId;
    }
}
