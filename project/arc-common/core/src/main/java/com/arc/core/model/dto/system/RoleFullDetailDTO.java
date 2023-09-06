package com.arc.core.model.dto.system;

import com.arc.core.model.domain.system.security.Role;
import com.arc.core.model.domain.system.security.SysResource;
import lombok.Data;

import java.util.List;

@Data
public class RoleFullDetailDTO extends Role {

    private List<SysResource> resources;


}
