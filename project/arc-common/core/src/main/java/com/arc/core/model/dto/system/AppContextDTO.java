package com.arc.core.model.dto.system;

import com.arc.core.model.domain.system.security.User;
import com.arc.core.model.domain.system.security.UserAuth;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AppContextDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    boolean auth;
    User user;
    UserAuth userAuth;
    String ticket;

    public AppContextDTO() {
    }

    public AppContextDTO(boolean auth, UserAuth userAuth) {
        this.auth = auth;
        this.userAuth = userAuth;
    }
}
