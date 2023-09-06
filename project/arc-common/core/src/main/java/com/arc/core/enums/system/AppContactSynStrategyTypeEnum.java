package com.arc.core.enums.system;

import com.arc.core.enums.EnumNumberInterface;

/**
 * 通讯路同步策略类型
 *
 * @author 叶超
 * @since 2020/2/29 11:09
 */
@Deprecated
public enum AppContactSynStrategyTypeEnum implements EnumNumberInterface {

    /**
     * 合并重复数据
     */
    UNION_SET(1, "取并集"),
    ONLY_ACCEPT_SERVER(2, "仅取服务器的数据"),
    ONLY_ACCEPT_CLIENT(3, "仅取客户端数据"),
    ;


    private int key;

    private String message;

    AppContactSynStrategyTypeEnum(int key, String message) {
        this.key = key;
        this.message = message;
    }

    @Override
    public int getKey() {
        return key;
    }

    public void setFlag(int key) {
        this.key = key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getTag() {
        return this.getClass().getSimpleName();
    }
}
