package com.arc.core.model.response.app;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * APP联系人表Response
 *
 * @author lamy
 * @since
 */
@Getter
@Setter
public class AppContactResponse {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
    private String cellphone;
    private String displayName;
    private String email;
    private String groupMembership;
    private Integer id;
    private String im;
    private String name;
    private String nickname;
    private String organization;
    private Object photo;
    private String postalAddress;
    private Integer state;
    private String telephone;

}
