package com.arc.core.model.dto.system;

import com.arc.core.model.domain.system.security.User;
import lombok.Data;

import java.util.List;

@Data
public class UserFullDetailDTO extends User {

    /**
     * 用户组
     */
    private List<UserGroupFullDetailDTO> userGroups;


}

