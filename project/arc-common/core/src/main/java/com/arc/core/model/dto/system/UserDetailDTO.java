package com.arc.core.model.dto.system;

import com.arc.core.model.domain.system.security.User;
import com.arc.core.model.domain.system.security.UserAuth;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户授权信息表
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    User userSaved;
    UserAuth userAuthSaved;

    public UserDetailDTO(User userSaved, UserAuth userAuthSaved) {
        this.userSaved = userSaved;
        this.userAuthSaved = userAuthSaved;
    }
}
