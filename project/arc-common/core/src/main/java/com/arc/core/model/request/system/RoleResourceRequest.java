package com.arc.core.model.request.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author May
 * @since 2020/4/5 21:34
 */
@Data
@Deprecated
public class RoleResourceRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源的ids
     */
    private Set<Long> resourceIds;


}
