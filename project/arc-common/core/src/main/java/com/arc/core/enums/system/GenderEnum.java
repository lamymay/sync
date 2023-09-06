package com.arc.core.enums.system;

import com.arc.core.enums.EnumNumberInterface;

/**
 * @author 叶超
 * @since 2020/4/17 0:10
 */
public enum GenderEnum implements EnumNumberInterface {

    UNKNOWN(0, "保密"),
    MALE(1, "男"),
    FEMALE(2, "女");

    private int key;
    private String message;

    GenderEnum(int key, String message) {
        this.key = key;
        this.message = message;
    }

    public static GenderEnum getDisplayByKey(int key) {

        for (GenderEnum sex : GenderEnum.values()) {
            if (sex.getKey() == key) {
                return sex;
            }
        }
        return null;
    }


    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public String getMessage() {
        return this.message;

    }

    @Override
    public String getTag() {
        return this.getClass().getSimpleName();
    }

}
