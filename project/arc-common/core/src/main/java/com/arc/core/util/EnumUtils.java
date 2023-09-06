package com.arc.core.util;

import com.arc.core.enums.EnumNumberInterface;
import com.arc.core.enums.EnumStringInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 枚举工具类
 *
 * @author yehcoa
 */
public final class EnumUtils {

    private final static Logger log = LoggerFactory.getLogger(EnumUtils.class);

    private static Map<Class, Map<Integer, Enum<? extends EnumNumberInterface>>> CACHE_NUMBER_KEY_ENUM = new ConcurrentHashMap<>();

    private static Map<Class, Map<String, Enum<? extends EnumStringInterface>>> CACHE_STRING_KEY_ENUM = new ConcurrentHashMap<>();


    private EnumUtils() throws Exception {
        throw new RuntimeException("util class EnumUtils should not be initialized");
    }

    /**
     * 指定值获取对应枚举类型的枚举值
     *
     * @param value     值
     * @param enumClass 枚举类
     * @param <T>
     * @return 值不存在时返回{@code null}；否则返回对应的枚举值
     */
    public static <T extends Enum<? extends EnumNumberInterface>> T getEnumByKey(Integer value, Class<T> enumClass) {
        if (value == null) {
            return null;
        }
        Map<Integer, Enum<? extends EnumNumberInterface>> enumMap = CACHE_NUMBER_KEY_ENUM.computeIfAbsent(enumClass, EnumUtils::toMap);
        return Optional.ofNullable(enumMap).map(map -> (T) map.get(value)).orElse(null);
    }


    /**
     * 枚举转map
     * note: 枚举需要实现{@code EnumNumberInterface}接口
     *
     * @param enumClass 枚举类类型
     * @param <T>       枚举类型，需要实现{@link EnumNumberInterface}
     * @return key为{@link EnumNumberInterface}, value为{@code Class<T>} 类型的枚举实例
     */
    public static <T extends Enum<? extends EnumNumberInterface>> Map<Integer, Enum<? extends EnumNumberInterface>> toMap(Class<T> enumClass) {
        Map<Integer, Enum<? extends EnumNumberInterface>> enumMap = new HashMap<Integer, Enum<? extends EnumNumberInterface>>();
        for (T enumValue : enumClass.getEnumConstants()) {
            enumMap.put(((EnumNumberInterface) enumValue).getKey(), enumValue);
        }
        return enumMap;
    }


    /**
     * 指定值获取对应枚举类型的枚举值
     *
     * @param value     值
     * @param enumClass 枚举类
     * @param <T>
     * @return 值不存在时返回{@code null}；否则返回对应的枚举值
     */
    public static <T extends Enum<? extends EnumStringInterface>> T getEnumByKey(String value, Class<T> enumClass) {
        if (value == null) {
            return null;
        }
        Map<String, Enum<? extends EnumStringInterface>> enumMap = CACHE_STRING_KEY_ENUM.computeIfAbsent(enumClass, EnumUtils::toStringKeyMap);
        return Optional.ofNullable(enumMap).map(map -> (T) map.get(value)).orElse(null);
    }


    /**
     * 枚举转map
     * note: 枚举需要实现{@code EnumStringInterface}接口
     *
     * @param enumClass 枚举类类型
     * @param <T>       枚举类型，需要实现{@link EnumStringInterface}
     * @return key为{@link EnumStringInterface}, value为{@code Class<T>} 类型的枚举实例
     */
    public static <T extends Enum<? extends EnumStringInterface>> Map<String, Enum<? extends EnumStringInterface>> toStringKeyMap(Class<T> enumClass) {
        Map<String, Enum<? extends EnumStringInterface>> enumMap = new HashMap<>();
        for (T enumValue : enumClass.getEnumConstants()) {
            enumMap.put(((EnumStringInterface) enumValue).getKey(), enumValue);
        }
        return enumMap;
    }
}
