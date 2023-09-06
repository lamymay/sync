package com.arc.core.model.dto.system;

import lombok.Data;

import java.util.List;

@Data
public class UserRoleDTO {

    List<Long> rolesIds;// 角色id
    private Long userId;// 自增id

}
