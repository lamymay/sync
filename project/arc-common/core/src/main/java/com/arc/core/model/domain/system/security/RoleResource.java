package com.arc.core.model.domain.system.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统RBAC-角色到资源关系表-多对多 是中间表 _relation
 *
 * @author 叶超
 * @since 2019/9/29 23:13
 */
@Data
@TableName("security_role_resource")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色id roleid role_id
     */
    private Long roleId;

    /**
     * 资源id  resourceid resource_id
     */
    private Long resourceId;


    public RoleResource() {
    }

    public RoleResource(Long roleId, Long resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }
}
