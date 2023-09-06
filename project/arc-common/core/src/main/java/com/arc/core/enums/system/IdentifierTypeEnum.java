package com.arc.core.enums.system;


import com.arc.core.enums.EnumNumberInterface;

/**
 * 枚举类 标识类型
 *
 * @author may
 */
public enum IdentifierTypeEnum implements EnumNumberInterface {

    //   private String identifier;// 标识（手机号 邮箱 用户名或第三方应用的唯一标识） 1=username/password 2=cellphone 3= 4=wechat 5=weibo 6=qq

    USERNAME(1, "username/password"),
    CELLPHONE(2, "cellphone"),
    EMAIL(3, "email"),
    ;


    private int key;

    private String message;

    IdentifierTypeEnum(int key, String message) {
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
