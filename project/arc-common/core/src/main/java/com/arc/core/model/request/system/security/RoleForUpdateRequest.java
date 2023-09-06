package com.arc.core.model.request.system.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

/**
 * 接收更新数据的实体bean
 *
 * @author May
 * @since 2020/1/7 10:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleForUpdateRequest {
    //header
    private HttpHeaders headers;


    private String id;
    private String code;
    private String name;
    private String description;


}

// todo 警告: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
//@Data
//^
