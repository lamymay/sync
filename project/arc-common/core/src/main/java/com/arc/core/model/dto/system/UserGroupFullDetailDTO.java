package com.arc.core.model.dto.system;

import com.arc.core.model.domain.system.security.UserGroup;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class UserGroupFullDetailDTO extends UserGroup {

    private List<RoleFullDetailDTO> roles;

    private Map<Object, Object> extendMap = new HashMap<>();


}

