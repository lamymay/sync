package com.arc.core.model.request.system.security;

/**
 * @author may
 * @since 2022.01.25 4:18 下午
 */

import lombok.Data;
import org.springframework.http.HttpHeaders;

/**
 * Resource 相关请求参数的模型
 *
 * @author May
 * @since 2020/1/7 10:19
 */
@Data
public class ResourceRequest {

    //header
    private HttpHeaders headers;
    private String roleId;
    private String category;


}