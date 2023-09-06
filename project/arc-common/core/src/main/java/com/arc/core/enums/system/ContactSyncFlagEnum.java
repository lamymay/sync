package com.arc.core.enums.system;

import com.arc.core.enums.EnumNumberInterface;

/**
 * 同步方案
 * 0=未定义
 * 1=云端替换本地=仅仅保留云端(清空本地数据并用云端数据替换本地)
 * 2=本地替换云端=仅仅保留本地(清空云端数据并用本次发送的数据替换云端)
 * 3=合并保存以云端为准(假定:云端张三=1361234,本地张三=1331234。合并后-->张三=1361234)
 * 4=合并保存以本地客户端为准 (假定:云端张三=1361234,本地张三=1331234。合并后-->张三=1331234)
 * 5=合并服务端均保留 (同名则追加)
 * 6=清空云端数据&本地客户端数据
 */
public enum ContactSyncFlagEnum implements EnumNumberInterface {

    ONLY_KEEP_SERVER(1, "仅仅保留云端"),// only keep old(server)
    ONLY_KEEP_CLIENT(2, "仅仅保留客户端"),// delete old(server) than insert
    MERGE_SERVER_CLIENT(3, "合并服务端均保留(同名则追加)"),//save or update
    REMOVE_ALL(4, "清空云端数据&本地客户端数据"),// delete all
//    MERGE_SERVER_CLIENT_AND_TRUST_SERVER(5, "合并保存以云端为准"),
//    MERGE_SERVER_CLIENT_AND_TRUST_CLIENT(6, "合并保存以本地客户端为准"),

    ;


    private int key;

    private String message;

    ContactSyncFlagEnum(int key, String message) {
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


    public static String info;

    static {
        StringBuilder appender = new StringBuilder();
        for (ContactSyncFlagEnum contactSyncFlagEnum : ContactSyncFlagEnum.values()) {
            appender.append(contactSyncFlagEnum.getKey()).append("=").append(contactSyncFlagEnum.getMessage())
                    .append("; ");
        }
        info = appender.toString();
    }


}
