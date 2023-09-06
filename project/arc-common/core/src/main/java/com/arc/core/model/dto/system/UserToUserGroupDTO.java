package com.arc.core.model.dto.system;

import lombok.Data;

import java.util.Set;

@Data
public class UserToUserGroupDTO {

    private Long userId;

    Set<Long> userGroupIds;


}

