package com.arc.core.model.domain.system.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户授权信息表
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@TableName("security_user_auth")
public class UserAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;//用户授权信息表ID
    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间

    private Long userId;//用户的id
    private String identifier;// 标识（手机号 邮箱 用户名或第三方应用的唯一标识） 1=username/password 2=cellphone 3=email 4=wechat 5=weibo 6=qq
    private String credential;// 密码凭证（站内的保存密码，站外的不保存或保存token）
    private Integer identityType;// 登录类型（1用户名 2手机号 3邮箱 4微信 5微博等）
    private Integer verified;// 验证与否

    private Integer status;// 状态(逻辑删除/停用)

    public UserAuth(String identifier, String credential, int identityType) {
        super();
        this.identifier = identifier;
        this.credential = credential;
        this.identityType = identityType;
    }

    public UserAuth(String identifier, String credential) {
        super();
        this.identifier = identifier;
        this.credential = credential;
        this.identityType = 0;
    }

    public UserAuth(Long id, String identifier, String credential) {
        this.id = id;
        this.identifier = identifier;
        this.credential = credential;
    }
}
