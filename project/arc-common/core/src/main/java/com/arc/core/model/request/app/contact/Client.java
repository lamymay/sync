package com.arc.core.model.request.app.contact;

import lombok.Data;

@Data
public class Client {

    /**
     * 用户id，后期会从用户的登录状态中解析出来
     */
    private Long userId;

    /**
     * 客户端id
     * app在不同设备上对应挂在不同人的账户下
     */
    private String clientId;


    public Client() {
    }

    public Client(Long userId) {
        this.userId = userId;
    }

    public Client(Long userId, String clientId) {
        this.userId = userId;
        this.clientId = clientId;
    }
}
